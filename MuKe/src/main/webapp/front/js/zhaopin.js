var  maxstrlen=200;//评论出输入字数的最大数
//点击评论输入框出现的特效
function checkWord(c){
	len=maxstrlen;
	var str =c.value;
		myLen=getStrleng(str);
		if(myLen>len){
			for(var i=0;i<str.length;i++){
				str=str.replace(' ','');//循环去掉空格
			}
			c.value=str.substring(0,len);
			document.getElementById("shenzi").innerHTML ="剩余"+0+"字";
		}else{
			document.getElementById("shenzi").innerHTML ="剩余"+(200-myLen)+"字";;
		}
	}
	//计算出当前输入文字的字数
	function getStrleng(str){
		for(var i=0;i<str.length;i++){
			str=str.replace(' ','');//循环去掉空格
		}
		return str.length;
		}
	