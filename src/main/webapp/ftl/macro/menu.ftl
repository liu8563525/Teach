<#assign checkPermission= "com.beyondsoft.common.util.FtlCheckPermissionMethod"?new()>
<#macro leftMenu menu>
	<div class="left_block clearfix">
	  <div class="leftmenu">
		<ul>

				<li <#if menu == "Account_Management">class="on"</#if>><a href="javascript:windowLocationHref('${base}/account/initAddNewAccount.do');">Account Management</a></li>

				<li <#if menu == "Role_Management">class="on"</#if>><a href="javascript:windowLocationHref('${base}/role/initRoleManagement.do');">Role Management</a></li>

				<li <#if menu == "Reset_Password">class="on"</#if>><a href="javascript:windowLocationHref('${base}/reset/initReset.do');">Reset Password</a></li>

				<li <#if menu == "Review_History">class="on"</#if>><a href="javascript:windowLocationHref('${base}/review/review.do');">Review History</a></li>

		</ul>
	  </div>
	  <span></span>
	</div>
</#macro>

