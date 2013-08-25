<#macro greet person>
<div>Hello ${person}!</div>
</#macro>
<#--
 | 取得时间的function，省去了各种判断
 -->
<#function getTime time="">
<#if time?is_date>
<#return time?string("yyyy-MM-dd HH:mm:ss")>
<#else>
<#return time>
</#if>
</#function>

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

<#function isClosed account>

<#return account.active == 'N'/>

</#function>
