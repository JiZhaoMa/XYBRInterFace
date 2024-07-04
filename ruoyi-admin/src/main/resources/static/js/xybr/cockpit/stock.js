//饼图
function createStockPie(newClientPie, monthStr) {
    let paramDate;
    let option = {
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
                var res = '库存总金额 <br/>';
                if(params.data.name === '材料库存' || params.data.name === '整机库存'){
                    res += params.data.value + "W";
                }
                if(params.data.name === '20kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock003 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock004 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock005 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock006 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock007 +'<br/>'
                }
                if(params.data.name === '30kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock009 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock010 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock011 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock012 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock013 +'<br/>'
                }
                if(params.data.name === '40kW'){
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock015 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock016 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock017 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock018 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock019 +'<br/>'
                }
                if(params.data.name === paramDate.stockData.stock045){ //top1
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock025 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock026 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock027 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock028 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock029 +'<br/>'
                }
                if(params.data.name === paramDate.stockData.stock046){//top2
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock030 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock031 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock032 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock033 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock034 +'<br/>'
                }
                if(params.data.name === paramDate.stockData.stock047){//top3
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock035 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock036 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock037 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock038 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock039 +'<br/>'
                }
                if(params.data.name === '其他'){//其他
                    res += params.data.value + "W <br/>";
                    res += '库龄信息： <br/>'
                    res += '1-3个月：' + paramDate.stockData.stock040 +'<br/>'
                    res += '4-6个月：' + paramDate.stockData.stock041 +'<br/>'
                    res += '7-9个月：' + paramDate.stockData.stock042 +'<br/>'
                    res += '10-12个月：' + paramDate.stockData.stock043 +'<br/>'
                    res += '12个月以上：' + paramDate.stockData.stock044 +'<br/>'
                }
                return res;
            }
        },
        series: [
            {
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
            },
            {
                name:'库存',
                type:'pie',
                radius: ['60%', '100%'],
                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner'
                    }
                },
                data:[
                    {value:0, name:''},
                    {value:0, name:''},
                    {value:0, name:''},
                    {value:0, name:'其他'},
                    {value:0, name:'20kW'},
                    {value:0, name:'30kW'},
                    {value:0, name:'40kW'},
                ],
                color: ['#00c7ff', '#00c7ff', '#00c7ff', '#00c7ff','#2fffa4', '#2fffa4', '#2fffa4'],
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
            option.series[0].data[0].value = data.stockData.stock020;//材料库存
            option.series[0].data[1].value = data.stockData.stock001;//整机库存
            option.series[1].data[0].value = data.stockData.stock021;//top1
            option.series[1].data[1].value = data.stockData.stock022;//top2
            option.series[1].data[2].value = data.stockData.stock023;//top3
            option.series[1].data[0].name = data.stockData.stock045;//top1名称
            option.series[1].data[1].name = data.stockData.stock046;//top1名称
            option.series[1].data[2].name = data.stockData.stock047;//top1名称
            option.series[1].data[3].value = data.stockData.stock024;//其他
            option.series[1].data[4].value = data.stockData.stock002;//20kW
            option.series[1].data[5].value = data.stockData.stock008;//30kW
            option.series[1].data[6].value = data.stockData.stock014;//40kW
            paramDate = data;
            newClientPie.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
}