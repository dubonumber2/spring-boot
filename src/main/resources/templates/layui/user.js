var table;
layui.use('table', function(){
    table = layui.table;
});
table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
        if(data.rolename==null){
            layer.open({
                type: 2 //此处以iframe举例
                ,title: '分配角色'
                ,area: ['390px', '330px']
                ,shade: 0
                ,offset: [ //为了演示，随机坐标
                    '100px','300px'
                ]
                ,maxmin: true
                ,content: 'rolelist.html'
                ,btn: ['确认', '取消'] //只是为了演示
                ,btn1: function(index,layero){
                    var a=$(layero).find('iframe')[0].contentWindow.rolename;
                    var user_id=data.id;
                    $.ajax({
                     url:'/role/fenpei.action?rolename='+a+'&user_id='+user_id,
                     dataType:'text',
                     type:'post',
                     success:function(data){
                     if(data==="success"){
                     layer.msg('分配角色成功',{icon:1},function(){
                     table.reload("test");
                     layer.close(index);
                     });
                     }else if(data==="no"){
                     layer.msg('分配角色失败',{icon:2},function(){
                     var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                     parent.layer.close(index);
                     });
                     }
                     }

                     })
                }
                ,btn2: function(){
                    layer.closeAll();
                }


            });
        }else{
            layer.msg("该用户已有角色，请重新选择",{icon:2})
        }

    } else if(layEvent === 'del'){
        layer.confirm('真的删除行么', function(index){

            $.ajax({
                url:'/user/deleteUser.action?id='+data.id,
                dataType:'text',
                type:'post',
                success:function(data){
                    if(data==="success"){
                        layer.msg('删除成功',{icon:1},function(){

                            layer.close(index);
                        });
                    }else if(data==="no"){
                        layer.msg('删除失败',{icon:2},function(){
                            layer.close(index);
                        });
                    }
                }

            })
            obj.del(); //删除对应行（tr）的DOM结构
        });
    } else if(layEvent === 'edit'){
        layer.open({
            type: 2,
            area: ['400px', '400px'], //宽高
            skin: 'layer-ext-seaning',
            content:'updateUser.html',
            success:function (layero,index) {
                //获取到弹出层的窗口对象
               var iframeWin=window[layero.find('iframe')[0]['name']];
                if(null!=iframeWin){
                    //调用弹出层的方法，传值回显
                    iframeWin.test(data.id,data.username,data.password,data.email,data.realName,data.rolename);
                }
            },
            end:function () {
                table.reload("test");
            }

        });
    }
});

$('#button1').click(function(){
    layer.open({
        type: 2,
        area: ['400px', '400px'], //宽高
        content:'/admin/insertUser.html'

    });


})