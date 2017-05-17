

function init() {
completeField = document.getElementById("searchId");
completeTable = document.getElementById("complete-table");
autoRow = document.getElementById("auto-row");
}
function test(productName,productId)
{
  row=document.createElement("tr");
  cell = document.createElement("td");
  textnode=document.createTextNode(productName);
  cell.appendChild(textnode);
  row.appendChild(cell);
  completeTable.appendChild(row);
}

function callbac(req)
{

  test(req.readyState);



}


function doCompletion() {
  //test("George");
var x=document.getElementById("searchId");

var url = "autocomplete?searchId="+escape(searchId.value)+"&action=complete&random=ran" ;



var req =initRequest(); //initRequest();
/*
req.open("GET", url, true);
req.send();
test(req.responseText);
*/
var xhttp = new initRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      //parseMessages(this.responseText);
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();

}
function initRequest() {

if (window.XMLHttpRequest) {

if (navigator.userAgent.indexOf('MSIE') != -1) {
isIE = true;
}

return new XMLHttpRequest();
} else if (window.ActiveXObject) {
isIE = true;
return new ActiveXObject("Microsoft.XMLHTTP");
}
}
function appendProduct(productName,productId) {
var row;
var cell;
var linkElement;
if (isIE) {
completeTable.style.display = 'block';
row = completeTable.insertRow(completeTable.rows.length);
cell = row.insertCell(0);
} else {
completeTable.style.display = 'table';
row = document.createElement("tr");
cell = document.createElement("td");
row.appendChild(cell);
completeTable.appendChild(row);
}
cell.className = "popupCell";
linkElement = document.createElement("a");
linkElement.className = "popupItem";
linkElement.setAttribute("href", "autocomplete?action=lookup&searchId=" + productId);
linkElement.appendChild(document.createTextNode("George"));
cell.appendChild(linkElement);
}
function parseMessages(responseXML) {
// no matches returned
//test(responseXML);
if (responseXML == null) {

return false;

}
else {

var products = responseXML.getElementsByTagName("products")[0];

if (products.childNodes.length > 0) {
completeTable.setAttribute("bordercolor", "black");
completeTable.setAttribute("border", "1");

for (loop = 0; loop < products.childNodes.length; loop++) {
var product = products.childNodes[loop];
var productName = product.getElementsByTagName("productName")[0];
var productId = product.getElementsByTagName("id")[0];


test(productName.childNodes[0].nodeValue,productId.childNodes[0].nodeValue);

}
}
}
}
function callback() {

clearTable();
if (req.readyState == 4) {
if (req.status == 200) {
parseMessages(req.responseXML);
}
}
}
function clearTable() {
if (completeTable.getElementsByTagName("tr").length > 0) {
completeTable.style.display = 'none';
for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
completeTable.removeChild(completeTable.childNodes[loop]);
}
}
}
