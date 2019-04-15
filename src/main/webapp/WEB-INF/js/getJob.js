//学员id验证
	function checkId() {
		//姓名验证
		var text1 = document.getElementById("id");
		var res1 = document.getElementById("id1");
		var n1 = document.getElementById("id").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}
    //学员姓名验证
	function checkName() {
		//姓名验证
		var text1 = document.getElementById("stuName");
		var res1 = document.getElementById("stuName1");
		var n1 = document.getElementById("stuName").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "姓名不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	function checkSex() {
		//性别验证
		var text1 = document.getElementById("sex");
		var res1 = document.getElementById("sex1");
		var n1 = document.getElementById("sex").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "性别不能为空";
			text1.style.border = "red solid 1px";
	      }
    }
	//公司名称验证
	function checkCompanyName() {
		//性别验证
		var text1 = document.getElementById("comName");
		var res1 = document.getElementById("comName1");
		var n1 = document.getElementById("comName").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "公司名称不能为空";
			text1.style.border = "red solid 1px";
	      }
    }
	//职位验证
	function checkPosition() {
		//性别验证
		var text1 = document.getElementById("position");
		var res1 = document.getElementById("position1");
		var n1 = document.getElementById("position").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "职位名称不能为空";
			text1.style.border = "red solid 1px";
	      }
    }
	//薪资验证
	function checkSal() {
		//获取元素的值和节点
		var text1 = document.getElementById("sal");
		var res1 = document.getElementById("sal1");
		var n1 = document.getElementById("sal").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "薪资不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//入职时间验证
	function checkTime() {
		//获取元素的值和节点
		var text1 = document.getElementById("entryDate");
		var res1 = document.getElementById("entryDate1");
		var n1 = document.getElementById("entryDate").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "入职时间不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//入职地点验证
	function checkPlace() {
		//获取元素的值和节点
		var text1 = document.getElementById("entryPlace");
		var res1 = document.getElementById("entryPlace1");
		var n1 = document.getElementById("entryPlace").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "入职地点不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//是否想换行业验证
	function checkChangeTrade() {
		//获取元素的值和节点
		var text1 = document.getElementById("changeTrade");
		var res1 = document.getElementById("changeTrade1");
		var n1 = document.getElementById("changeTrade").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//是否想换工作验证
	function checkChangeWork() {
		//获取元素的值和节点
		var text1 = document.getElementById("changeWork");
		var res1 = document.getElementById("changeWork1");
		var n1 = document.getElementById("changeWork").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//离职时间验证
	function checkDimission() {
		//获取元素的值和节点
		var text1 = document.getElementById("dimission");
		var res1 = document.getElementById("dimission1");
		var n1 = document.getElementById("dimission").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//原因验证
	function checkReason() {
		//获取元素的值和节点
		var text1 = document.getElementById("reason");
		var res1 = document.getElementById("reason1");
		var n1 = document.getElementById("reason").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}
	//备注验证
	function checkComments() {
		//获取元素的值和节点
		var text1 = document.getElementById("comments");
		var res1 = document.getElementById("comments1");
		var n1 = document.getElementById("comments").value;
		//用户名规则的正则表达式
		var reg1 = /\S/;
		//验证是否符合规则
		if (reg1.test(n1)) {
			res1.innerHTML = "";
			text1.style.border = "0px";
		} else {
			res1.innerHTML = "不能为空";
			text1.style.border = "red solid 1px";
		}
	}