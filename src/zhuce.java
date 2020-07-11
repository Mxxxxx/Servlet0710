import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Meng Xin
 * @Date 2020/7/10 19:41
 */
@WebServlet("/zhuce")
public class zhuce extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String username1 = req.getParameter("username");
        String password1 = req.getParameter("password");
        User.zhuce(username1, password1);
        writer.println("<p>注册成功</p>");
    }
}
