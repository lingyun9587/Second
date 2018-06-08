package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMapper2;
import com.example.demo.pojo.User;
import com.example.demo.pojo.User2;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 9:40   2018/6/4
 */
@Controller
public class Hello {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapper2 userMapper2;
    //private static Logger log= Logger.getLogger(Hello.class);
    @Autowired
    private UserService userService;

    @Value("${valueTest}")//获取配置文件中的自定义属性
            /*private*/ String getValue;


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    // @GetMapping("hello")
    public String hello() {

        PageHelper.startPage(1, 5, true);
        List<User2> list22 = userMapper2.userLlist();
        System.out.println("分页测试：" + list22.size());

        PageInfo<User2> info = new PageInfo<>(list22);
        info.getList().forEach(p -> System.out.println(p.toString()));
        System.out.println(info.getList().size());
//log.info("log4jlog4jlog4jlog4jlog4jlog4jlog4jlog4jlog4jlog4jlog4j");
       /* System.out.println(list22.get(16));
        System.out.println(userMapper2.userLlist().size());
*/
        //System.out.println("jpa测试查询："+userMapper.findAll().size());
        List list = userMapper.findAll();
        System.out.println(list.size());

        /*Iterator it = list.iterator();
        while(it.hasNext()) {
            User user=(User)it.next();
            System.out.println(user.getId()+"====="+user.getUsernme()+"==="+user.getPassword());
        }
        System.out.println(userMapper.findOne(75).toString());
       // userMapper.delete(82);
        System.out.println("二次测试："+userMapper.getOne(75));*/
        /*    User user = new User();
        user.setUsernme("cc");
        user.setPassword("ccc");
        user.setLoginname("cccc");
        User user1=userMapper.save(user);
        System.out.println(user1.toString());*/
        //userMapper.delete(84);

        return "Hello Springboot!";
    }

    @RequestMapping(value = "test", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        System.out.println("message1");
        userService.test01();
        System.out.println("message2");
        System.out.println(getValue);
        return getValue;
    }

    @ResponseBody
    @RequestMapping(value = "fenye", method = RequestMethod.GET)
    public Object selectNewsList() {

        PageHelper.startPage(4, 5);
        List<User2> userLlist = userMapper2.userLlist();
        PageInfo<User2> appsPageInfo = new PageInfo<>(userLlist);


        System.out.println("pages:" + appsPageInfo.getPages());
        if (StringUtils.isEmpty(userLlist)) {
            return "查询消息列表失败";
        }
        appsPageInfo.getList().forEach(p -> System.out.println(p.toString()));
        System.out.println("分页后集合长度：" + appsPageInfo.getList().size());
        return appsPageInfo.getList();
    }

    //进入上传文件的页面
    @RequestMapping(value = "ce", method = RequestMethod.GET)
    public String ce(HttpServletRequest request) {
        return "ce";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Object upStu(@RequestParam(value = "t_pic", required = false) MultipartFile pic
            , HttpServletRequest request) {

        String fileName = "";
        String newName = "";

        if (!pic.isEmpty()) {
            {
                String path = request.getSession().getServletContext().getRealPath("static/img");


                fileName = pic.getOriginalFilename();
                System.out.println("文件的后缀名：" + FilenameUtils.getExtension(fileName));
                newName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName);
                //System.out.println("重命名的文件名：" + newName);
                File file = new File(path, newName);
                System.out.println("项目中态资源文件夹中img的路径" + path);
                try {
                    pic.transferTo(file);
                    System.out.println("文件上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "上传成功";


    }

    @RequestMapping(value = "htmlUpload", method = RequestMethod.GET)
    public String htmlUpload() {

        return "upload";
    }

    @RequestMapping(value = "htmlUpload", method = RequestMethod.POST)
    @ResponseBody
    public Object htmlUpload(@RequestParam(value = "t_pic", required = false) MultipartFile pic
            , HttpServletRequest request) {

        String fileName = "";
        String newName = "";
        if (!pic.isEmpty()) {
            {

                if (pic.getSize() <= 1048576) {
                    System.out.println(pic.getSize());
                    String path = request.getSession().getServletContext().getRealPath("static/img");
                    fileName = pic.getOriginalFilename();
                    newName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName);
                    //System.out.println("重命名的文件名：" + newName);
                    File file = new File(path, newName);
                    System.out.println("项目中态资源文件夹中img的路径" + path);
                    try {
                        pic.transferTo(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "上传成功";
                }
            }
        }
        return "上传失败";
    }

    //测试文件下载
    @RequestMapping(value = "/testDownload", method = RequestMethod.GET)
    public void Download(HttpServletResponse res) {
        String fileName = "FLAMING MOUNTAIN.JPG";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\123\\Pictures\\"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }



   /* @RequestMapping(value = "abbb", method = RequestMethod.GET)
    public String aaa() {

        return "aaa/bb";
    }*/



}
