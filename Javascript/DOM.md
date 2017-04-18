## 1. Document Object Model
---

When a browser loads a file, it creates DOM. DOM is an API for valid HTML and well-formed XML documents. It defines the logical structure of specification. With DOM, programmers can build documents, navigate their structure, and add, modify, or delete elements and content. Anything found in an HTML or XML document can be accessed, changed, deleted or added using DOM.


DOM provides a standard programming interface that can be used in a wide variety of environments and applications. The DOM is designed to be used with any programming language.

DOM provides the following two features.

1. Creating a model for a HTML document
  After a browser loads a HTML document, it creates a model in memory. The model consists of a tree for the object. **DOM tree**

2. Accessing and modifying a HTML document
  DOM provides methods and attributes which help access nodes (objects) in the DOM tree in the model. When DOM is modified, the content the user sees on the browser changes too.


  > DOM tree is created by a browser.

  In order to manipulate the content of a webpage, we need to access DOM, and select the attribute to modify, then use innerHTML in JavaScript.

## 2. DOM Query
---

  1. Selecting one element

  ``` JavaScript
  var elem = document.getElementById('one');
  elem.className = 'blue';
  ```
  This uses a CSS selector. When multiple elements are selected, only the first one is returned.

  2. Selecting more than one elements

  ```JavaScript
  var elems = document.getElementsByClassName('red'), i;
  for (i=0; i<elems.length; i++){
    elems[i].className = 'blue';
  }
  ```
The code above doesn't work because the return type of getElementsByClassName is HTMLCollection, which uses an **array-like object**. forEach isn't allowed

>HTMLCollection reflects the status of a node dynamically.

[For ways to bypass this problem] (http://poiemaweb.com/js-dom)
