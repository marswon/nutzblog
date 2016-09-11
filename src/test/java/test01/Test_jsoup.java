package test01;


import net.javablog.util.JsoupBiz;

public class Test_jsoup {

    public static void main(String[] args) {
        String html = "\"<h2 id=\"h2-u6982u8FF0\"><a name=\"概述\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>概述</h2><p>通过Servlet方法中的doOptions方法确定服务器端允许哪些其它域的资源对本方法（get，post）发起请求。</p> <h2 id=\"h2-u4EE3u7801u5B9Eu73B0\"><a name=\"代码实现\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>代码实现</h2><h3 id=\"h3-servlet-\"><a name=\"Servlet 代码\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Servlet 代码</h3><pre><code class=\"lang-java\">package servlets; import javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; import java.io.IOException; import java.io.PrintWriter; public class ServletCross extends HttpServlet { @Override protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { if (&quot;http://localhost:63343&quot;.equals(req.getHeader(&quot;Origin&quot;))) { resp.addHeader(&quot;Access-Control-Allow-Origin&quot;, req.getHeader(&quot;Origin&quot;)); // resp.addHeader(&quot;Access-Control-Max-Age&quot;, &quot;120&quot;); // in seconds // resp.addHeader(&quot;Access-Control-Allow-Credentials&quot;, &quot;true&quot;); resp.addHeader(&quot;Access-Control-Allow-Methods&quot;, &quot;HEAD, GET, OPTIONS, POST&quot;); resp.addHeader(&quot;Access-Control-Allow-Headers&quot;, &quot;Content-Type,origin, content-type, accept, x-requested-with&quot;); } } protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException { doGet(req, resp); } protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException { if (req.getHeader(&quot;Origin&quot;) != null) { resp.addHeader(&quot;Access-Control-Allow-Origin&quot;, req.getHeader(&quot;Origin&quot;)); // resp.addHeader(&quot;Access-Control-Allow-Credentials&quot;, &quot;false&quot;); // resp.setHeader(&quot;Connection&quot;, &quot;keep-alive&quot;); } resp.setContentType(&quot;text/html&quot;); PrintWriter pw = null; try { pw = resp.getWriter(); } catch (IOException e) { e.printStackTrace(); } pw.write(&quot;&lt;h1&gt; hello first servlet!&lt;/h1&gt;&quot;); } } </code></pre> <h3 id=\"h3-u5BA2u6237u7AEFu4EE3u7801\"><a name=\"客户端代码\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>客户端代码</h3><pre><code class=\"lang-html\">&lt;!DOCTYPE html&gt; &lt;html lang=&quot;en&quot;&gt; &lt;head&gt; &lt;meta charset=&quot;UTF-8&quot;&gt; &lt;title&gt;test Cross Domain&lt;/title&gt; &lt;script src=&quot;http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js&quot;&gt;&lt;/script&gt; &lt;script&gt; $(function () { $.ajax(&quot;http://127.0.0.1:8080/cross&quot;, { type: &quot;POST&quot;, contentType: &quot;application/json; charset=utf-8&quot;, data: {&quot;data&quot;: 1111}, success: function(data, status, xhr) { console.log(&quot;success! data:&quot; + data); }, error: function(xhr, status, error) { console.log(&quot;error&quot;); } }); }); &lt;/script&gt; &lt;/head&gt; &lt;body&gt; &lt;/body&gt; &lt;/html&gt; </code></pre> <h2 id=\"h2-u8FD0u884Cu67E5u770Bu6548u679C\"><a name=\"运行查看效果\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>运行查看效果</h2><p>服务器端所在的域是 <a href=\"http://127.0.0.1:8080\">http://127.0.0.1:8080</a><br>客户端所在的域是 <a href=\"http://localhost:63343\">http://localhost:63343</a></p> <p>虽然是两个不同的源，但是POST请求可以正常返回200。<br>表明跨域成功。</p> <p>但是如果客户端的请求地址是<br><a href=\"http://127.0.0.1:63343/test_web/test01/index.html\">http://127.0.0.1:63343/test_web/test01/index.html</a></p> <p>那么会响应不允许访问<br>因为服务器端配置的只允许 <a href=\"http://localhost:63343\">http://localhost:63343</a> 这一个域可以跨域访问。</p> <p>需要注意的是<br><a href=\"http://localhost:63343\">http://localhost:63343</a><br><a href=\"http://127.0.01:63343\">http://127.0.01:63343</a><br><a href=\"http://127.0.0.1:8080\">http://127.0.0.1:8080</a><br>是三个不同的源</p> <h2 id=\"h2-u53C2u8003u5730u5740\"><a name=\"参考地址\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>参考地址</h2><p><code>https://segmentfault.com/a/1190000003710973</code></p> <h2 id=\"h2-u6E90u7801u5730u5740\"><a name=\"源码地址\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>源码地址</h2><p><code>https://coding.net/u/javacore/p/cross-domain/git</code></p> \"";

        String html2=JsoupBiz.getTextFromTHML(html);


        System.out.println();
    }
}