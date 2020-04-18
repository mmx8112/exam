<!DOCTYPE html>
<html>
<head>
    <title>用户列表展示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#assign path = "${springMacroRequestContext.getContextPath()}">
    <!-- Bootstrap -->
    <link href="${path}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${path}/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
<h1 class="badge-warning">用户列表展示</h1>

<div class="box-body">
    <div class="table-responsive">
        <table class="table table-striped">
            <tr class="success">
                <th width="300px" scope="col">姓名</th>
                <th scope="col">电话</th>
                <th scope="col">得分</th>
            </tr>

        </table>
    </div>
</div>


<script src="/static/js/jquery.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>