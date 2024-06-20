function createChinaMap(myChart, month) {
    var effectScatterItemStyle = { type: 'radial',
        x: 0.5,
        y: 0.5,
        r: 0.5,
        colorStops: [{
            offset: 0, color: '#ffa800' // 0% 处的颜色
        }, {
            offset: 1, color: '#dd0000' // 100% 处的颜色
        }],
        global: false }
    var points = [
        // 点坐标
        { value: [86.25167 , 45.44452 ], itemStyle: { color: effectScatterItemStyle}, name: '西北'},
        { value: [113.56913 , 42.85388], itemStyle: { color: effectScatterItemStyle }, name: '华北'},
        { value: [112.32099 , 30.44534 ], itemStyle: { color: effectScatterItemStyle }, name: '华中'},
        { value: [118.08968 , 34.74876 ], itemStyle: { color: effectScatterItemStyle }, name: '华东'},
        { value: [109.53131 , 23.18507], itemStyle: { color: effectScatterItemStyle }, name: '华南'},
        { value: [90.53131 , 30.18507], itemStyle: { color: effectScatterItemStyle }, name: '西南'},
        { value: [125.83103 , 46.89552], itemStyle: { color: effectScatterItemStyle }, name: '东北'}
    ]
    var points1 = [
        // 提示坐标
        { value: [87 , 45 ], itemStyle: { color: effectScatterItemStyle}, name: '西北'},
        { value: [113 , 42], itemStyle: { color: effectScatterItemStyle }, name: '华北'},
        { value: [109 , 30 ], itemStyle: { color: effectScatterItemStyle }, name: '华中'},
        { value: [120 , 33 ], itemStyle: { color: effectScatterItemStyle }, name: '华东'},
        { value: [108 , 22], itemStyle: { color: effectScatterItemStyle }, name: '华南'},
        { value: [89 , 29], itemStyle: { color: effectScatterItemStyle }, name: '西南'},
        { value: [127 , 46], itemStyle: { color: effectScatterItemStyle }, name: '东北'}
    ]
    var showVlas={
        西北 : [12345] ,
        华北 : [12345] ,
        东北 : [12345] ,
        华南 : [12345] ,
        西南 : [12345] ,
        华中 : [12345] ,
        华东 : [12345] ,
    }
    let option = {
        title: {
            text: '七大区销售额(：万元)',
            left: 'center',
            top: '0%',
            textStyle: {
                color: '#ffffff',
                fontStyle: 'normal',
                fontWeight: 800,
            }
        },
        tooltip: {
            trigger: 'item',
            triggerOn: 'click|mousemove',
            backgroundColor:'rgb(147, 235, 248)',
            borderColor: '#3574c8',
            show: false,
            formatter: function(params) {
                var res;
                if (params.value > 0) {
                    var area = "";
                    if(params.value == 1){
                        area = "华北地区";
                    }
                    if(params.value == 2){
                        area = "西南地区";
                    }
                    if(params.value == 3){
                        area = "华中地区";
                    }
                    if(params.value == 4){
                        area = "东北地区";
                    }
                    if(params.value == 5){
                        area = "华东地区";
                    }
                    if(params.value == 6){
                        area = "西北地区";
                    }
                    if(params.value == 7){
                        area = "华南地区";
                    }
                    res = area + "销售额" + "<br/>" + "2000W";
                } else {
                    res = '';
                }
                return res;
            }

        },
        visualMap: {
            min: 0,
            max: 7,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],
            calculable: true,
            show:false,
            inRange: {
                color: ['#FFF', '#210A57', '#210A57', '#330440', '#264240', '#213E66', '#213E66', '#264240'],
            }
            //华北      西南    华中     东北     华东    西北     华南
        },
        geo: {
            map: 'china',
            selectedMode: 'none',
            silent: true,
            zoom: 1.2,
            aspectScale: 1,
            top: "8%",
            z: 1,
            label: {
                normal: {
                    show: false,
                    color: '#333'
                },
                emphasis: {
                    show: false,
                    color: '#fff'
                }
            },
            itemStyle: {
                normal: {
                    shadowColor: 'rgba(0, 0, 0.5, 0.5)',
                    borderColor: '#0a53e9',
                    shadowBlur: 15,
                    shadowOffsetX: 5, // 阴影水平方向上的偏移
                    shadowOffsetY: 5 // 阴影垂直方向上的偏移
                },
                emphasis: {
                    areaColor: '#000'
                }
            }
        },
        series: [
            {

                type: 'map',
                mapType: 'china',
                geoIndex: 0,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{
                    name: '北京',
                    value: 1
                }, {
                    name: '天津',
                    value: 1
                }, {
                    name: '河北',
                    value: 1
                },{
                    name: '山西',
                    value: 1
                }, {
                    name: '内蒙古',
                    value: 1
                }, {
                    name: '重庆',
                    value: 2
                }, {
                    name: '云南',
                    value: 2
                }, {
                    name: '贵州',
                    value: 2
                }, {
                    name: '四川',
                    value: 2
                }, {
                    name: '西藏',
                    value: 2
                }, {
                    name: '河南',
                    value: 3
                },{
                    name: '湖南',
                    value: 3
                }, {
                    name: '湖北',
                    value: 3
                },{
                    name: '辽宁',
                    value: 4
                }, {
                    name: '黑龙江',
                    value: 4
                }, {
                    name: '吉林',
                    value: 4
                }, {
                    name: '安徽',
                    value: 5
                }, {
                    name: '浙江',
                    value: 5
                }, {
                    name: '山东',
                    value: 5
                }, {
                    name: '江西',
                    value: 5
                }, {
                    name: '江苏',
                    value: 5
                }, {
                    name: '福建',
                    value: 5
                }, {
                    name: '上海',
                    value: 5
                }, {
                    name: '新疆',
                    value: 6
                }, {
                    name: '甘肃',
                    value: 6
                },  {
                    name: '青海',
                    value: 6
                }, {
                    name: '陕西',
                    value: 6
                }, {
                    name: '宁夏',
                    value: 6
                },  {
                    name: '广东',
                    value: 7
                }, {
                    name: '海南',
                    value: 7
                },{
                    name: '广西',
                    value: 7
                }, {
                    name: '台湾',
                    value: 0
                }, {
                    name: '香港',
                    value: 0
                }, {
                    name: '澳门',
                    value: 0
                }, {
                    name: '南海诸岛',
                    value: 0
                }]
            },
            {
                type: 'map',
                selectedMode: 'none',
                silent: true,
                mapType: 'china',
                aspectScale: 1,
                zoom: 1.2,
                top: "11.5%",
                z: 0,
                itemStyle:{
                    normal: {
                        areaColor: '#0C0333'
                    }
                }
            },
            {
                name: 'companyPoint',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                showEffectOn: 'render',
                // zlevel: 2, // zlevel用于 Canvas 分层 相同的绘制在同一个canvas上
                rippleEffect: {
                    number: 3, // 波纹数量
                    period: 4, // 动画周期 数值越大，波动越慢
                    scale: 3.5, // 动画中波纹的最大缩放比例
                    brushType: 'stroke' // 波纹的绘制方式 stroke fill
                },
                label: {
                    show: false,
                    position: 'bottom',
                    fontWeight: 400,
                    formatter: '{b}',
                    color: 'black',
                    fontSize: 14
                },
                symbol: 'circle',
                symbolSize: 16,
                data: points,
                z: 4
            },
            {
                name: '销售额',
                type: 'scatter',
                coordinateSystem: 'geo',
                label: {
                    show: true,
                    position: 'bottom',
                    formatter:function(param){
                        var val = param.name + `\n` + "销售额";
                        val += showVlas[param.name][0]+'\n'
                        return val
                    },
                    color: '#FFF',
                    fontSize: 14
                },
                symbol: 'circle',
                symbolSize: 1,
                data: points1,
                z: 4
            },
        ]
    };
    myChart.setOption(option);

    /*myChart.on('mouseover', function(params) {
        var city = params.name;

        if (city == '广东' || city == '广西' || city == '海南') {
            myChart.dispatchAction({
                type: 'highlight',
                name: "广东"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "广西"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "海南"
            });
        }

        if (city == '山东' || city == '江苏' || city == '浙江' || city == '安徽' || city == '江西' || city == '福建' || city == '上海') {

            myChart.dispatchAction({
                type: 'highlight',
                name: "山东"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "江苏"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "浙江"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "安徽"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "江西"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "福建"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "上海"
            });
        }

        if (city == '湖北' || city == '河南' || city == '湖南') {

            myChart.dispatchAction({
                type: 'highlight',
                name: "湖北"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "河南"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "湖南"
            });

        }

        if (city == '重庆' || city == '四川' || city == '贵州' || city == '云南' || city == '西藏') {

            myChart.dispatchAction({
                type: 'highlight',
                name: "重庆"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "四川"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "贵州"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "云南"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "西藏"
            });

        }
        if (city == '北京' || city == '天津' || city == '河北' || city == '山西' || city == '内蒙古') {

            myChart.dispatchAction({
                type: 'highlight',
                name: "北京"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "天津"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "河北"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "山西"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "内蒙古"
            });
        }
        if (city == '陕西' || city == '甘肃' || city == '青海' || city == '宁夏' || city == '新疆' ) {
            myChart.dispatchAction({
                type: 'highlight',
                name: "陕西"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "甘肃"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "青海"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "宁夏"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "新疆"
            });

        }
        if (city == '辽宁' || city == '吉林' || city == '黑龙江') {

            myChart.dispatchAction({
                type: 'highlight',
                name: "辽宁"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "吉林"
            });
            myChart.dispatchAction({
                type: 'highlight',
                name: "黑龙江"
            });
        }

    });

    myChart.on('mouseout', function(params) {
        var city = params.name;
        if (city == '广东' || city == '广西' || city == '海南') {
            myChart.dispatchAction({
                type: 'downplay',
                name: "广东"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "广西"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "海南"
            });
        }

        if (city == '山东' || city == '江苏' || city == '浙江' || city == '安徽' || city == '江西' || city == '福建' || city == '上海') {
            myChart.dispatchAction({
                type: 'downplay',
                name: "山东"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "江苏"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "浙江"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "安徽"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "江西"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "福建"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "上海"
            });
        }

        if (city == '湖北' || city == '河南' || city == '湖南') {

            myChart.dispatchAction({
                type: 'downplay',
                name: "湖北"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "河南"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "湖南"
            });

        }

        if (city == '重庆' || city == '四川' || city == '贵州' || city == '云南' || city == '西藏') {

            myChart.dispatchAction({
                type: 'downplay',
                name: "重庆"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "四川"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "贵州"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "云南"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "西藏"
            });

        }
        if (city == '北京' || city == '天津' || city == '河北' || city == '山西' || city == '内蒙古') {

            myChart.dispatchAction({
                type: 'downplay',
                name: "北京"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "天津"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "河北"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "山西"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "内蒙古"
            });
        }
        if (city == '陕西' || city == '甘肃' || city == '青海' || city == '宁夏' || city == '新疆' ) {
            myChart.dispatchAction({
                type: 'downplay',
                name: "陕西"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "甘肃"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "青海"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "宁夏"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "新疆"
            });

        }
        if (city == '辽宁' || city == '吉林' || city == '黑龙江') {

            myChart.dispatchAction({
                type: 'downplay',
                name: "辽宁"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "吉林"
            });
            myChart.dispatchAction({
                type: 'downplay',
                name: "黑龙江"
            });
        }
    });*/
    myChart.setOption(option,true);
}