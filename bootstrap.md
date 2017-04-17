## 1. Media Query

Bootstrap supports Mobile-first as default therefore any definition
not included in **Media Query** is for devices with 768px or below.

There are 4 breakpoints.

```CSS
@media (min-width: @screen-sm-min){

}
@media (min-width: @screen-md-min){

}
@media (min-width: @screen-lg-min) {   

}
```
@ signifies variables of LESS. LESS is a preprocessor and the source code of Bootstrap is based on Less and Sass.

```Sass
@nice-blue: #5B83AD;
@light-blue: @nice-blue + #111;

#header { color: @light-blue; }
```

Above is compiled as following.
```CSS
#header { color: #6c94be; }
```
## 2. Container
Bootstrap has to have a container(wrapper) because it's a grid-based system.

2 containers **CANNOT** be nested lest padding gets mesed up.

  ### 2.1 Fixed Width Container (Responsive Fixed Layout)

It's used when Responsive Fixed Layout is needed. It responds to Media Query and within the same breakpoint, it has the fixed width even if viewport width expands or shrinks.

  ### 2.2 Full Width Container (Fluid Layout)

Unlike fixed width container, it's used to create fluid layout. Regardless of the viewport, contents max out on the screen.


```CSS
.container-fluid {
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}
```

```HTML
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
  <style>
    .container, .container-fluid {
      background: #eaeaed;
    }
    .fixed, .fluid {
      background: #2db34a;
      height: 100px;
      line-height: 100px;
      text-align: center;
      color: white;
      font-weight: 700;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="fixed">fixed width (.container)</div>
  </div>
  <br>
  <div class="container-fluid">
    <div class="fluid">full width (.container-fluid)</div>
  </div>
</body>
</html>
```
