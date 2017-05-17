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
  linkelement=document.createElement("a");
  linkelement.title="test";
  linkelement.href="Product_Display?ID="+productId+"&random=ran"
  linkelement.appendChild(textnode);
  cell.appendChild(linkelement);
  row.appendChild(cell);
  completeTable.appendChild(row);
  cell.className = "popupCell";



}
function xml(responseXML)
{
  if (responseXML == null)
  {
    return false;
  }
  else {
    var products = responseXML.getElementsByTagName("products")[0];
    if (products.childNodes.length > 0)
    {
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


function doCompletion() {
var url = "autocomplete?searchId="+escape(searchId.value)+"&action=complete&random=ran" ;

var xhttp =initRequest();
xhttp.open("GET", url, true);
xhttp.send();
xhttp.onreadystatechange = function() {

  if (this.readyState == 4 && this.status == 200) {
    clearTable();
    xml(this.responseXML);

  }
};


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

function clearTable()
{
  if (completeTable.getElementsByTagName("tr").length > 0)
  {
    //completeTable.style.display = 'none';
    for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--)
     {
       completeTable.removeChild(completeTable.childNodes[loop]);
     }
   }
}
