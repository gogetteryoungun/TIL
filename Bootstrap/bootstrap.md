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

## 3. Grid system

Aforementioned .container and .container-fluid are parent elements for contents and are called 'wrappers'. Containers are a prerequisite for a grid system.
System here refers to Layout. Bootstrap provides us with **responsive 12 row grid system**.

In order to create a grid layout, .row includes .col-\*-\*. Container> .row>.col-\*\*



```
.container
  .row
    .col-xs-#
    .col-xs-#
  .row
    .col-xs-#
    .col-xs-#
```



Bootstrap supports up to 12 columns. In place of the second \*, we can specify a number from 1 to 12.

ie. col-xs-1 means 1/12 of the row width is taken up for the column.

Also, col-xs-\* is aligned horizontally regardless of viewport.

.col-sm-\* is used when the viewport width is greater than 768px. When it's below that, instead of using Media Query of CSS, the block feature of 'div' is applied and stacks up vertically.

For viewport over 992px -> .col-md-\*
For viewport over 1200px -> .col-lg-\*



### Mixed Col- Class

```html
<div class="col-xs-12 col-sm-6">xs-12 sm-6</div>
```

If viewport width is lower than 768px, col-xs-12 is applied, else col-sm-6 is applied. However col-xs- is always applied as default.


# TIP!!
In a CSS file, a later definition comes BEFORE (has a higher priority than) a definition before it. col-sm-6 comes later than col-xs- in bootstrap.css

```html
<div class="row">
  <div class="col-sm-12 col-md-8">.col-sm-12 .col-md-8</div>
  <div class="col-sm-6">.col-sm-6</div>
</div>
```

In this example, when viewport is over 992px, the first div specifies col-md-8 for the case but the second div doesn't.
Therefore the second one uses .col-sm-6 even when it's over 992px.

Plus, min-width applies when it's beyond the set value. For example, **min-width: 768** applies when the viewport is over 768px.


```html
@media (min-width: 768px)
.col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9 {
  float: left;
}
```
Above applies when it's over 768px

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
  <style>
    .row {
      margin-bottom: 10px;
    }
    [class*="col-"] {
      background: #2db34a;
      border: 1px solid #eaeaed;
      height: 50px;
      font-size: .8em;
      line-height: 50px;
      text-align: center;
      color: white;
      font-weight: 700;
    }
  </style>
</head>
<body>
  <div class="container">
    <p>Viewport width가 992px 이상이면 3열, 미만이면 1열로 정렬된다</p>
    <div class="row">
      <div class="col-xs-12 col-md-4">1</div>
      <div class="col-xs-12 col-md-4">2</div>
      <div class="col-xs-12 col-md-4">3</div>
    </div>
  </div>
</body>
</html>
```

## 4. Mobile, Tablet, Desktop

Type | Breakpoint | Class Prefix
--- | --- | ---
Mobile | < 768px | .col-xs-
Tablet | >= 768px | .col-sm-
Desktop | >= 992px | .col-md-
