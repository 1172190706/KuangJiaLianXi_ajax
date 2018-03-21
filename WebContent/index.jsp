<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
     
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/bootstrap.css"/>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/bootstrap.js"></script> 
		
</head>
<body>

<!-- 模糊查询  -->
<form action="" id="likeForm">
模糊查询： 姓名：<input type="text" name="sname">
班级：<select name="classes.cid" class="classSelect">
<option value="">--请选择--</option>
</select>
<input type="button" value="提交" id="likeButton">
</form>

<button type="button" class="btn btn-primary">添加</button>
<!-- 添加 -->
<div id="addDiv" style="display: none;">
<form action="" id="addForm">
添加： 姓名：<input type="text" name="sname">
班级：<select name="classes.cid" class="classSelect">
<option value="">--请选择--</option>
</select>
<input type="button" value="提交" id="likeButton">
</form>
</div>

<table id="tab" class="table table-bordered">
<tr>
<td>编号</td>
<td>姓名</td>
<td>班级</td>
<td>操作</td>
</tr>
</table>

<script type="text/javascript">

/* 点击添加按钮显示div */
$("button:contains('添加')").on("click",function(){
$("#addDiv").removeAttr("style");
});

/* 点击删除按钮 */
/* $(".a").on("click",function(){
	
	alert(123);
	
}); */
$(document).on("click",".a",function(){
 //	 alert( $(this).val() );
   $.ajax({
	  url:"${pageContext.request.contextPath}/first/del",
	  data:"sid="+$(this).val(),
	 // dataType:"json", 指定返回json格式，而@ResponseBody只封装对象，集合
	//  type:"post",	  
      success:function(data){
    	  window.location.reload();
    	  
      }
  }); 
});

/* 查询班级 */
$.ajax({
	  url:"${pageContext.request.contextPath}/first/listClasses",
		 dataType:"json",
		 type:"post",	  
         success:function(data){
        	// console.log(data);
        	 $.each(data,function(i,n){
   		     $(".classSelect").append("<option value='"+n.cid+"'>"+n.cname+"</option>");				
   		 });
      }
});


/* 查询全部 */
$.ajax({
	  url:"${pageContext.request.contextPath}/first/list",
	  dataType:"json",
	  type:"post",
	  async:true,
	  success:function(data){
		 $.each(data,function(i,n){
		      $("#tab").append("<tr><td>"+n.sid+"</td><td>"+n.sname+"</td><td>"+n.classes.cname+"</td><td><button type='butto' class='a btn btn-danger' value='"+n.sid+"'>删除</button></td></tr>");				
		 });
		 
		 
		
	  }
	});




$(function(){
	
	/* 模糊查询 */
	$("#likeButton").on("click",function(){
		$.ajax({
			 url:"${pageContext.request.contextPath}/first/list",
			 dataType:"json",
			  type:"post",
			  async:true,
			  data:$("#likeForm").serialize(),
			  success:function(data){
				 // window.location.href;
				//  console.log(data);
				  $("tr").remove();
				  $("#tab").append("<tr><td>编号</td><td>姓名</td><td>班级</td><td>操作</td></tr>");
				  $.each(data,function(i,n){
				      $("#tab").append("<tr><td>"+n.sid+"</td><td>"+n.sname+"</td><td>"+n.classes.cname+"</td><td><button type='butto' class='a btn btn-danger' value='"+n.sid+"'>删除</button></td></tr>");				
				 });
			  }
		});
	});
	
	
	
});
</script>

</body>
</html>