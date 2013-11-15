<#macro html title>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>${title}</title>
	<#-- <link rel="stylesheet" rev="stylesheet" href="/oa/file/css.css" type="text/css" media="all" />-->
</head>
<body>
	<#nested/>
</body>
<@footer/>
</html>
</#macro>

<#macro footer>
<P id=copyRight align=center>
    <TABLE>
        <TBODY>
            <TR align=middle>
                <TD>版权所有</TD>
            </TR>
            <TR align=middle>
                <TD><A target=_blank>联系我们</A></TD>
            </TR>
        </TBODY>
    </TABLE>
</#macro>