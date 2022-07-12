function testFocus(id) {
    $("#" + id ).next().text('');
}
 
function testBlur(id,that) {
    if (that.value){
    	$("#" + id ).next().text('');
    }else {
    	$("#" + id ).next().text('此项不能为空');
    }
}
