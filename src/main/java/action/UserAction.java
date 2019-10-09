package action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import entity.Smuser;
import entity.Smuserword;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.*;
import util.SecurityCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserAction extends ActionSupport {
    //登录   修改查询 添加
    private User user;
    private int up;
    private int down;

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    private Smuser smuser;
    private List<Smuserword> smlist;

    public Smuser getSmuser() {
        return smuser;
    }

    public void setSmuser(Smuser smuser) {
        this.smuser = smuser;
    }

    private String smusername;
    private String smpassword;
    private String word;
    private int userid;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Smuserword> getSmlist() {
        return smlist;
    }

    public void setSmlist(List<Smuserword> smlist) {
        this.smlist = smlist;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSmusername() {
        return smusername;
    }

    public void setSmusername(String smusername) {
        this.smusername = smusername;
    }

    public String getSmpassword() {
        return smpassword;
    }

    public void setSmpassword(String smpassword) {
        this.smpassword = smpassword;
    }

    private Admin admin;

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    private String code;
    private String adminname;
    private String aname;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    //展示所有
    private List<User> users;
    //修改操作之前的查询 和删除的id
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    public String loginUser(){

        AdminService adminService = new AdminServiceImpl();
        Admin login = adminService.login(admin);
        if(login!=null){
            return "loginUserSuccess";
        }else{
            return "loginUserError";
        }
    }

    public String showAllUser(){
        UserService userService = new UserServiceImpl();
        users = userService.showAllUsers();
        return "showAllUserSuccess";
    }

    public String showUser(){
        UserService userService = new UserServiceImpl();
        user = userService.showUser(id);
        return "showUserSuccess";
    }
    public String upDateUser(){
        UserService us = new UserServiceImpl();
        //System.out.println(user);
        us.Update(user.getId(), user.getUsername(), user.getSalary(), user.getAge());
        return "upDateUserSuccess";
    }
    public String add(){
        UserService us = new UserServiceImpl();
        us.add(user.getUsername(), user.getSalary(), user.getAge());
        return "addSuccess";
    }
    public String delete(){

        UserService us = new UserServiceImpl();
        us.delete(id);
        return "deleteSuccess";
    }
    /*public String addadmin(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String fcode =(String) session.getAttribute("fcode");
        System.out.println("````````````"+fcode);
        //System.out.println("~~~~~~~~~~~"+number);

        if (fcode.equals(number)){
        AdminService as = new AdminServiceImpl();
       as.add(admin.getName(),admin.getUsername(),admin.getPassword(),admin.getSex());
        return "addSuccess1";
        }else{
           return  "addSuccess2";
        }
    }*/
    public void codeImg() throws Exception{
        //生成验证码随机字符(位数)
        String generateVerifyCode = SecurityCodeUtil.generateVerifyCode(4);
        System.out.println("生成的验证码"+generateVerifyCode);
        //HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("fcode", generateVerifyCode);
        //生成图片(宽度，高度，随即字符)
        BufferedImage image = SecurityCodeUtil.getImage(255, 80, generateVerifyCode);
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("image/png");

        //将生成的验证码图片保存到本地
        ImageIO.write(image, "png",response.getOutputStream());
        //return null;
    }
    public void ajax() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=response.getWriter();
        if ("李白".equals(adminname)){
            writer.print("用户名已存在");
        }else{
            writer.print("用户名可用");
        }
        writer.flush();

    }
    public void ajax1() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=response.getWriter();
        System.out.println(aname);
        if ("李白".equals(aname)){
            writer.print("用户名已存在");
        }else{
            writer.print("用户名可用");
        }
        writer.flush();

    }
    public void ajax2() throws IOException {
        System.out.println(id);
        UserService userService = new UserServiceImpl();
        user = userService.showUser(id);
        System.out.println(user);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");

        String jsonString = JSONObject.toJSONString(user);
        System.out.println(jsonString);
        PrintWriter writer=response.getWriter();
        writer.print(jsonString);
        writer.flush();

    }
    public void loginSmuser() throws IOException {

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        SmuserService ss= new SmuserServiceImpl();
        System.out.println(smusername+smpassword);
        Smuser smuser=ss.queryUserBynp(smusername,smpassword);
        if (smuser==null) {
            writer.print("no");
        } else {
            writer.print("ok");
        }
        writer.flush();

    }
    public String showAllsmword(){
        SmuserService ss= new SmuserServiceImpl();
        smuser=ss.queryByname(smusername);
        SmuserwordService sws=new SmuserwordImpl();
        smlist=sws.queryAll();
        return "showAllsmwordSuccess";
    }
    public void ajax3() throws IOException {
        System.out.println(word+userid);
        Smuserword ssw = new Smuserword(0,word,0,0,userid,username);
        SmuserwordService sws=new SmuserwordImpl();
        sws.add(ssw);
        smlist=sws.queryAll();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");

        String jsonString = JSONObject.toJSONString(smlist);
        System.out.println(jsonString);
        PrintWriter writer=response.getWriter();
        writer.print(jsonString);
        writer.flush();

    }
    public void ajax4() throws IOException {
        SmuserwordService sws=new SmuserwordImpl();
       //sws.add(ssw);
        sws.update(id,up,down);
        smlist=sws.queryAll();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");

        String jsonString = JSONObject.toJSONString(smlist);
        System.out.println(jsonString);
        PrintWriter writer=response.getWriter();
        writer.print(jsonString);
        writer.flush();

    }

}



