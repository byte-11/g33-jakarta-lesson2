package uz.pdp.g33jakartalesson2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Calculator</title>
                </head>
                <body>
                <h2>Calculator</h2>
                                
                <form action="" method="post">
                    <label for="x">
                        x : <input type="number" id="x" name="x">
                    </label>
                    <br>
                    <label for="y">
                        y : <input type="number" id="y" name="y">
                    </label>
                    <br>
                    <label for="operation">Operation : </label>
                    <select id="operation" name="operation">
                        <option value="-"> -</option>
                        <option value="+"> +</option>
                        <option value="*"> *</option>
                        <option value="/"> /</option>
                    </select>
                    <br>
                    <input type="submit" value="Submit">
                    <br>
                    <br>
                    <div>
                        Result : <span>%s</span>
                    </div>
                </form>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double x = req.getParameter("x") != null ? Double.parseDouble(req.getParameter("x")) : null;
        Double y = req.getParameter("y") != null ? Double.parseDouble(req.getParameter("y")) : null;
        String operation = req.getParameter("operation");

        Double result = null;
        if (operation != null) {
            switch (operation) {
                case "+" -> result = x + y;
                case "-" -> result = x - y;
                case "*" -> result = x * y;
                case "/" -> result = x / y;
            }
        }

        PrintWriter writer = resp.getWriter();
        writer.println(String.format("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Calculator</title>
                </head>
                <body>
                <h2>Calculator</h2>
                                
                <form action="" method="post">
                    <label for="x">
                        x : <input type="number" id="x" name="x">
                    </label>
                    <br>
                    <label for="y">
                        y : <input type="number" id="y" name="y">
                    </label>
                    <br>
                    <label for="operation">Operation : </label>
                    <select id="operation" name="operation">
                        <option value="-"> -</option>
                        <option value="+"> +</option>
                        <option value="*"> *</option>
                        <option value="/"> /</option>
                    </select>
                    <br>
                    <input type="submit" value="Submit">
                    <br>
                    <br>
                    <div>
                        Result : <span>%s</span>
                    </div>
                </form>
                </body>
                </html>
                """, result == null ? "" : result));
    }

    //http://localhost:8080/calculator?x=231&y=141&operation=%2B

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        if (method.equalsIgnoreCase("GET")){
            PrintWriter writer = resp.getWriter();
            writer.println("""
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <title>Calculator</title>
                        </head>
                        <body>
                            <h2>Calculator</h2>
                        </body>
                        </html>
                    """);
        }
    }*/
}
