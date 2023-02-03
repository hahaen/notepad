<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"></meta>
    <title>海报</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .certificate {
            position: relative;
            display: inline-block;
            width: 750px;
            height: 1288px;
            background-repeat: no-repeat;
            background-position: center;
            background-size: 750px 1288px;
            text-align: center;
        }

        .title {
            position: absolute;
            display: inline-block;
            width: 578px;
            margin: 0 86px;
            font-size: 34px;
            font-weight: 500;
            color: #E66C6C;
            font-family: simsun;
            line-height: 48px;
            top: 410px;
            padding-bottom: 14px;
            border-bottom: 2px solid #E66C6C;
            text-align: center;
        }

        .qr_code {
            position: absolute;
            width: 228px;
            height: 228px;
            background-color: #fff;
            top: 964px;
            left: 260px;


        }

        img {
            display: inline-block;
            width: 228px;
            height: 228px;
        }
    </style>
</head>
<body>
<div class="certificate" style="background-image: url(${bg})">
    <div class="title" style="word-break: break-all!important; word-wrap: break-word!important;">
        《${title?html}》
    </div>
    <div class="qr_code">
        <img src="${qrCode}" alt=""></img>
    </div>
</div>
</body>
</html>