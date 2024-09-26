//饼图
function createStockPie(newClientPie, monthStr) {
    let paramDate;
    let option = {
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
                var res = '库存总金额 <br/>';
                if(params.data.name === '20kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '0-3个月：' + paramDate.stockData.stock003 +'<br/>'
                    res += '3个月以上：' + paramDate.stockData.stock004 +'<br/>'
                }
                if(params.data.name === '30kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '0-3个月：' + paramDate.stockData.stock009 +'<br/>'
                    res += '3个月以上：' + paramDate.stockData.stock010 +'<br/>'
                }
                if(params.data.name === '40kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '0-3个月：' + paramDate.stockData.stock015 +'<br/>'
                    res += '3个月以上：' + paramDate.stockData.stock016 +'<br/>'
                }
                if(params.data.name === '材料库存'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '0-3个月：' + paramDate.stockData.stock025 +'<br/>'
                    res += '3个月以上：' + paramDate.stockData.stock026 +'<br/>'
                }
                return res;
            }
        },
        series: [
           /* {
                name:'库存',
                type:'pie',
                selectedMode: 'single',
                radius: [0, '45%'],

                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'材料库存', selected:true},
                    {value:679, name:'整机库存'}
                ],
                color: ['#2DB1EF', '#2fffa4'],
            },*/
            {
                name:'库存',
                type:'pie',
                radius: ['40%', '90%'],
                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner',
                        fontSize: nowSize(),
                    }
                },
                data:[
                    {value:0, name:''},
                    {value:0, name:''},
                    {value:0, name:''},
                    {value:0, name:''},
                ],
                color: ['#00c7ff','#2fffa4', '#2fffa4', '#2fffa4'],
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "/system/cockpit/getStockData",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": monthStr
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data[0].value = data.stockData.stock020;//top1
            option.series[0].data[1].value = data.stockData.stock002;//20kW
            option.series[0].data[2].value = data.stockData.stock008;//30kW
            option.series[0].data[3].value = data.stockData.stock014;//40kW
            if(data.stockData.stock020 > 0){
                option.series[0].data[0].name = '材料库存';
            }
            if(data.stockData.stock002 > 0){
                option.series[0].data[1].name = '20kW';
            }
            if(data.stockData.stock008 > 0){
                option.series[0].data[2].name = '30kW';
            }
            if(data.stockData.stock014 > 0){
                option.series[0].data[3].name = '40kW';
            }
            paramDate = data;
            newClientPie.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        newClientPie.setOption(option, true);
    });
    function nowSize(){
        let nowClientWidth = 12*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}