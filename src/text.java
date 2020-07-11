import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Meng Xin
 * @Date 2020/7/10 18:33
 */
@WebServlet("/mx")
public class text extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取用户的输入
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.验证用户输入的正确性，并得到对象
        User user = User.login(username, password);
        if (user == null) {
            //输入密码或者用户名错误

            writer.println("<p>密码或id错误</p>");
            return;
        } else {
            //3.设置Cookie和Session
            //设置了Session，tomcat会自动设置cookie
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //4.显示登录成功
            writer.println("<p>登录成功</p>");
        }
    }
}
