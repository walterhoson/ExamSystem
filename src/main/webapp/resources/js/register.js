/* $(function () {
            $("#serializeUrl").click(function () {
                testJquerySerializeUrl();
            });
        });

        function testJquerySerializeUrl() {
            var serializeUrl = $("#test_form").serialize();
            alert("序列化为url格式为："+serializeUrl);
        }*/

$(document).ready(function() {
    $('#Registerform').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                trueName: {
                    message: '姓名格式不合法',
                    validators: {
                        notEmpty: {
                            message: '姓名不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 4,
                            message: '姓名长度必须在2到4位之间'
                        },
                       /* remote: {
                            url: 'remote.php',
                            message: 'The username is not available'
                        },*/
                        regexp: {
                            regexp: /^[\u4e00-\u9fa5]+$/,
                            message: '姓名只能是中文'
                        }
                    }
                },
                email: {
                	validators: {
                        notEmpty: {
                            message: '邮箱地址不能为空'
                        },
                        emailAddress: {
                            message: '邮箱地址格式有误'
                        }
                    }
                },
                tel: {
                    validators: {
                        phone: {
                            message: '手机号格式有误',
                            country:'CN'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: '确认密码不能为空'
                        },
                        identical: {
                            field: 'password',
                            message: '两次输入的密码不一致'
                        }
                    }
                },
            }
        })
});

$("#Registerform").submit(function(ev){ev.preventDefault();});
$("#validateBtn").on("click", function(){

   var bootstrapValidator = $("#Registerform").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	   $("#Registerform").submit();
	   
   }else{
	   return;
   }

});