package com.spring.mvc.servlet.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet(){
        System.out.println("Register Servlet 객체 생성!");
    }

    @Override  //서블릿이 제공하는 메서드가 있다.
                            //요청정보들은 req에         응답정보는 resp에 담긴다는 것이다. 이 서블릿이 다 알아서 해준다.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        PrintWriter w = resp.getWriter();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        w.write("<!DOCTYPE html>\n");
        w.write("<html lang='ko'>\n");
        w.write("<head>\n");
//        w.write("<meta charset='EUC-KR'>\n");
        w.write("<title>회원가입 양식</title>\n");
        w.write("<style>label { display: block; }</style>\n");

        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action='/reg-process' method='post'>\n");
        w.write("<label># account: <input type='text' name='account'></label>\n");
        w.write("<label># password: <input type='password' name='password'></label>\n");
        w.write("<label># username: <input type='text' name='userName'></label>\n");
        w.write("<label><button type='submit'>register</button></label>\n");



        w.write("</form>\n");

        w.write("</body>\n");
        w.write("</html>\n");
    }
}
