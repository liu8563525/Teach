function login(){
	var userName=$("#txtUserName").val();
	var password=$("#txtUserPassword").val();
	//var type=$("#type").val();
	var type=$("input[name='type']:checked").val();
	
	//判断用户名
	if(userName==""||userName==null){
		alert("用户名不能为空!");
		$("#txtUserName").focus();
		return false;	
	}
	if(userName.indexOf(" ") >= 0)
	{
		alert("用户名不能包含空格!");
		$("#txtUserName").focus();
		return false;
	}
	
	//判断密码
	if(password==""||password==null){
		alert("密码不能为空!");
		$("#txtUserPassword").focus();
		return false;	
	}
	if(password.indexOf(" ") >= 0)
	{
		alert("密码不能包含空格!");
		$("#txtUserPassword").focus();
		return false;
	}
	
	//alert(userName);
	//alert(password);
	//alert(type);
	$.ajax({
		type:"post",
		url:"login/login.spr",
		dataType:"json",
		data:{"name":userName,"password":password,"type":type},
		success:function(data){
			if("fail"==data.result){
				alert("密码错误");
				return false;
			}else if("none"==data.result){
				alert("用户不存在");
				return false;
			}
			//$("#loginForm").submit();
		},
		error:function(data){
			//var r=eval('('+data+')');
			//var r=$.parseJSON(data);
			//var r2=data.toJSONString();
			//console.log(r2);
			//console.log(data);
			//console.log(data.success);
			//alert("2"+data.success);
		}
	});	
}