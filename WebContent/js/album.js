$(document).ready(function()
{
	// 页面加载时向pageLoad发送请求
	$.getScript("pageLoad");
});
function reset()
{
	// 清空user、pass两个单行文本框
	$("#user").val("");
	$("#pass").val("");
}
// 切换到注册对话框
function changeRegist()
{
	// 隐藏登录用的两个按钮
	$("#loginDiv").hide("500");
	// 显示注册用的两个按钮
	$("#registDiv").show("500");
}
// 处理用户登录的函数
function proLogin()
{
	// 获取user、pass两个文本框的值
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" 
		|| pass == null|| pass =="")
	{
		alert("必须先输入用户名和密码才能登录");
		return false;
	}
	else
	{
		// 向proLogin发送异步、POST请求
		$.post("proLogin", $('#user,#pass').serializeArray()
			, null , "script");
	}
}
// 处理用户注册的函数
function regist()
{
	// 获取user、pass两个文本框的值
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" || pass == null || pass =="")
	{
		alert("必须先输入用户名和密码才能注册");
		return false;
	}
	else
	{
		// 向proRegist发送异步、POST请求
		$.post("proRegist", $('#user,#pass').serializeArray()
			, null , "script");
	}
}

// 验证用户名是否可用
function validateName()
{
	// 获取user文本框的值
	var user = $.trim($("#user").val());
	if (user == null || user == "")
	{
		alert("您还没有输入用户名！");
		return false;
	}
	else
	{
		// 向validateName发送异步、POST请求
		$.post("validateName", $('#user').serializeArray()
			, null , "script");
	}
}

// 周期性地获取当前用户、当前页的相片
function onLoadHandler()
{
	// 向getPhoto发送异步、GET请求
	$.getScript("getPhoto");
	// 指定1秒之后再次执行此方法
	setTimeout("onLoadHandler()", 1000);
}

// 上传文件的回调函数
function callback(msg)
{
	alert(msg);
	// 隐藏文件上传的对话框
	$('#uploadDiv').dialog('close');
	// 清空title、file两个表单域。
	$('#title,#file').val('');
	$('#hideframe').attr('src' , '');
}

// 显示照片
function showImg(fileName)
{
	$.getScript("showImg?img=" + fileName);
}

// 处理翻页的函数
function turnPage(flag)
{
	$.getScript("turnPage?turn=" + flag);
}

// 打开上传窗口
function openUpload()
{

	$("#uploadDiv").show()
		.dialog(
		{
			modal: true,
			title: '上传照片',
			resizable: false,
			width: 428,
			height: 220,
			overlay: {opacity: 0.5 , background: "black"}
		});
}