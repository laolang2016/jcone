/**
 * 
 */
$(document).ready(function() {
    $(".text_login").focus(function() {
        if ($(this).val() == 'employee id' || $(this).val() == 'password') {
            $(this).val('');
        }
        if ($(this).attr('id') == 'user_pwd1') {
            $(this).hide();
            $('#user_pwd').show();
            $('#user_pwd').focus();
        }
    });
    $(".text_login").blur(function() {
        if ($(this).attr('id') == 'user_pwd' && $(this).val() == '') {
            $(this).hide();
            $('#user_pwd1').show();
            $('#user_pwd1').val('password');
        } else if ($(this).attr('id') == 'user_id' && $(this).val() == '') {
            $(this).val('employee id');
        }
    });
});