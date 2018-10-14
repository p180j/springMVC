
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function tranjson() {
        alert("11");
        var jsonStr ='{"merchantCode":"TESTCODE2",\n' +
        '"serialNo":"1234567q345678f",\n' +
        '"bizType":"106",\n' +
        '"operationType":"01",\t\n' +
        '"bizList":[\t\n' +
        '\t{"bizNo":"13456787654345"},\n' +
        '\t{"otherNo":"10"},\n' +
        '\t{"operationRet":""},\n' +
        '\t{"remark1":"皮皮1"},\n' +
        '\t{"remark2":"皮皮2"}]\n' +
        '}'
        var jsonObj =  JSON.parse(jsonStr)
        console.log(jsonObj)
        var jsonStr1 = JSON.stringify(jsonObj)
        console.log(jsonStr1+"jsonStr1")
    }

</script>
<body>
helloWord!
  <input type="button" onclick="tranjson() " value="转化"/>
</body>
</html>
