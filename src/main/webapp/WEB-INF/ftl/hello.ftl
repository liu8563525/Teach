<#import "macro/macro.ftl" as c>
<#--
 | 取得日期的function，省去了各种判断
 -->
<#function getDate time="">
<#if time?is_date>
<#return time?string("yyyy-MM-dd")>
<#else>
<#return time>
</#if>
</#function>
<#assign configArr=['热点资讯','HotNews','oh yeah']>
<html>
<head>
	<script type="text/javascript" src="${jsRoot}jquery-1.10.2.min.js"></script>
</head>
<body>
    <h1>say hello ${name}</h1><br/>
    ${(1 == 1)?string("yes", "no")}
    <#if name=='liu'>
    nihao
    <#else>
    oo
    </#if>
	<@c.greet person='${name}'/>
	${getDate('20130808')}
	<@spring.messageArgs 'welcome1' configArr/>
</body>
</html>