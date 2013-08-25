<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>FreeMarker自定义分页标签使用示例</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  </head>
  <body>
  <div style="margin: 0px auto; width:700px">
  	<div id="title">
  	  <h3>FreeMarker自定义分页标签使用示例</h3><hr/>
  	</div>

  	<div id="search">
  	<form name="myForm"  method="post">
		<table border="1" width="650px" align="center">
		  <tr>
		  	<td align="right" width="150px">根据名称模糊搜索:</td>
		  	<td><input type="text" name="name" value="${RequestParameters.name!''}"/>&nbsp;
		  	    <input type="submit" value=" 搜索 "/></td></tr>
		</table>
		</form>
  	</div>

  	<div id="data">
		<table border="1" width="650px" align="center">
			<#if datas??>
		  <#list datas as str>
		  <tr><td>${str}</td></tr>
		  </#list>
		  </#if>
		</table>
  	</div>
  	<div id="pagerInfo" style="margin:5px 0px; text-align:center;background-color:#FFFF00;color:blue">
  		共${recordCount}项,分${((recordCount+pageSize -1)/pageSize)?int}页
  	</div>
  	<hr/>
  	<div id="pager">
  		<#import "macro/page.ftl" as q>
  		<#if recordCount??>
  		<@q.pager pageNo=pageNo pageSize=pageSize recordCount=recordCount toURL="paging/"/>
  		</#if>
    </div>
  </div>
  </body>
</html>
