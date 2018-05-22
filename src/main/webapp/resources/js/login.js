$(document).ready(function() {
    $('#Loginform').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName: {
                    message: '用户名不合法',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 4,
                            message: '用户名长度必须在2到4位之间'
                        },
                        /*remote: {
                            url: 'remote.php',
                            message: 'The username is not available'
                        },*/
                        regexp: {
                        	regexp: /^[\u4e00-\u9fa5]+$/,
                        	message: '姓名只能是中文'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        })
       /* .on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post(
            		$form.attr('action'), 
            		$form.serialize(), 
            		function(result) {
            			alert("action");
            			console.log(result);
            		}, 'json');
        	});*/
});

$("#Loginform").submit(function(ev){ev.preventDefault();});
$("#validateBtn").on("click", function(){

   var bootstrapValidator = $("#Loginform").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	   $("#Loginform").submit();	   
   }else{
	   return;
   }

});