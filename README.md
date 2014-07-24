
<html><meta charset="UTF-8"><style>html { 
    font-size: 100%; 
    overflow-y: scroll; 
    -webkit-text-size-adjust: 100%; 
    -ms-text-size-adjust: 100%; 
}

body{
    font-family: helvetica, arial, freesans, clean, sans-serif;
    color: #333;
    background-color: #fff;
    border-color: #999999;
    border-width: 2px;
    line-height: 1.5;
    margin: 2em 3em;
    text-align:left;
    padding: 0 100px 0 100px;
}

pre{
    background-color: #eee;
    padding: 10px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    overflow: auto;
}
code{
    background-color: #eee;
    padding: 1px 3px;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    border-radius: 2px; 
}
pre code {
    padding-left: 0px;
    padding-right: 0px;
}
li p{
    margin: 0.3em;
}
ul > li{
    list-style-type: disc;
}
a:link, a:visited{
    color: #33e;
    text-decoration: none;
}
a:hover{
    color: #00f;
    text-shadow:1px 1px 2px #ccf;
    text-decoration:underline;
}
h1{
    color: #999;
    font-weight: 400;
    font-size: 36px;
}
h2{
    border-bottom: 1px dotted #aaa;
    margin-bottom: 1em;
    color: #333;
    font-size: 30px;
}
h3{
    color: #666;
    font-size: 24px;
}
h4 {
    font-size: 21px;
}
h5 {
    font-size: 18px;
}
.shadow{
    -webkit-box-shadow:0 5px 15px #000;
    -moz-box-shadow:0 5px 15px #000;
    box-shadow:0 5px 15px #000;     
}
</style><body><p><strong>Copyright@2014 KenLee All Rights Reserved</strong></p>
<p>1.根目录其实为</p>
<pre><code>- /Gridworld Project/GridWorldCode/projects
</code></pre>
<p>2.目录结构
    - firsprohect 为 Part1代码</p>
<pre><code>- boxBug      为 Part2~Part3代码

- critter     为 Part4代码

- sparsegrid  为 Part5代码
</code></pre>
<p>3.每个目录下的说明</p>
<pre><code>- build.xml         ant执行的build

- src               源文件(*.java)

- bin               图片+二进制文件(*.gif+*.class)

- TestRunner.java   main()函数文件，请把测试代码写在这。
</code></pre>
<p>4.怎样运行？</p>
<pre><code>- cd到带有build.xml的目录

- 把你的测试代码写到TestRunner.java

- 执行 ant 会自动编译运行
</code></pre></body></html>