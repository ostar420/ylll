var project_seq = '';
var project_version = '1.0';

function initBaseData(data){
    var baseData = {};
    baseData.project_seq=project_seq;
    baseData.project_version=project_version;
    baseData.data = JSON.stringify(data);
    return baseData;
}
function baseAjaxPost(url,data,successFun,errorFun){
    var tmpData = initBaseData(data);
    $.ajax({
            type: "post",
            data: tmpData,
            url: url,
            dataType: "json",
            success: function(d){
                if(typeof(successFun) !== "undefined")
                    successFun(d);
            },
            error: function(e){
                if(typeof(errorFun) !== "undefined")
                    errorFun(e);
            }
        });
}

