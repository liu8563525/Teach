<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>FreeMarker自定义分页标签使用示例</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  </head>
  <body>
  	<div id="page">
      <#assign prePage="${page.currentPage?number-1}">
      <#assign nextPage="${page.currentPage?number+1}">
      <#assign lastPage='${page.totalPages?number+1}'>
  	  <table>
      <tr><td>index</td><td>username</td><td>password</td><td>id</td></tr>
      <#list userlist as user> 
       <tr><td>${user_index}</td><td>${user.id}</td><td>${user.name}</td><td>${user.password?if_exists}</td</tr>
      </#list>
      <tr>
      <td>总行数:${page.totalRows}</td><td>总页数:${page.totalPages}</td>
      </tr>
      <tr>
      <#--<td><a href="javascript:void(0);">pre</a></td>-->
      <td><a href="1">首页</a>
      <#if (prePage>0)>
      <a href="${prePage}">&laquo;&nbsp;pre</a>
      <#else>
      <span class="disabled">&laquo;&nbsp;pre</span>
      </#if>
                     当前页:${page.currentPage}
      <#if (nextPage == lastPage)>
      <span class="disabled">next&nbsp;&raquo;</span>
      <#else>
      <a href="${nextPage}">next&nbsp;&raquo;</a>
      </#if>
      <a href="${page.totalPages}">末页</a></td>
      </tr>
      </table>
  	</div>
  </body>
</html>
