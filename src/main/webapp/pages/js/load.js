/**
 * Created by v_minjajlo on 02.11.2016.
 */
// = Load
// отслеживаем изменение инпута file
$('#file').change(function(){
    // Если файл прикрепили то заносим значение value в переменную
    var fileResult = $(this).val();
    // И дальше передаем значение в инпут который под загрузчиком
    $(this).parent().find('.fileLoad').find('input').val(fileResult);
});

/* Добавляем новый класс кнопке если инпут файл получил фокус */
$('#file').hover(function(){
    $(this).parent().find('button').addClass('button-hover');
}, function(){
    $(this).parent().find('button').removeClass('button-hover');
});
