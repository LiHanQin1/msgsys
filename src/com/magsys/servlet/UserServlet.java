package com.magsys.servlet;

import com.magsys.enyity.User;
import com.magsys.service.UserService;
import com.magsys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 19:08
 **/
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }
    //注册
    public void register( HttpServletRequest request,HttpServletResponse response){
       String username=request.getParameter("username");
       String password=request.getParameter("password");
       String email=request.getParameter("email");
        User user=new User(username,password,email);
        int result=userService.register(user);
        System.out.println(result);

    }
    //登录
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String token= (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("code");
        User user=userService.login(new User(username,password,null));
        if (token!=null&&token.equalsIgnoreCase(code)){
            if (user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            request.getRequestDispatcher("message.do?action=queryList").forward(request,response);

           }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
          }
        }else {
            response.getWriter().write("验证码输入错误！！！");
        }
    }
}
