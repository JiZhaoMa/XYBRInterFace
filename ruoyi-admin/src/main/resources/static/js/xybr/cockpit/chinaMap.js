function createChinaMap(myChart, cockpitData) {
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
        { value: [98.25167 , 37.44452 ], itemStyle: { color: effectScatterItemStyle}, name: '西北'},
        { value: [120.56913 , 42.85388], itemStyle: { color: effectScatterItemStyle }, name: '华北'},
        { value: [113.32099 , 32.44534 ], itemStyle: { color: effectScatterItemStyle }, name: '华中'},
        { value: [119.08968 , 31.74876 ], itemStyle: { color: effectScatterItemStyle }, name: '华东'},
        { value: [109.53131 , 22.18507], itemStyle: { color: effectScatterItemStyle }, name: '华南'},
        { value: [90.53131 , 30.18507], itemStyle: { color: effectScatterItemStyle }, name: '西南'},
        /*{ value: [125.83103 , 46.89552], itemStyle: { color: effectScatterItemStyle }, name: '东北'}*/
    ]
    var points1 = [
        // 提示坐标
        { value: [100 , 36 ], itemStyle: { color: effectScatterItemStyle}, name: '西北'},
        { value: [118 , 42], itemStyle: { color: effectScatterItemStyle }, name: '华北'},
        { value: [110 , 32 ], itemStyle: { color: effectScatterItemStyle }, name: '华中'},
        { value: [119 , 30.5 ], itemStyle: { color: effectScatterItemStyle }, name: '华东'},
        { value: [108 , 21.5], itemStyle: { color: effectScatterItemStyle }, name: '华南'},
        { value: [89 , 29], itemStyle: { color: effectScatterItemStyle }, name: '西南'},
        /*{ value: [127 , 46], itemStyle: { color: effectScatterItemStyle }, name: '东北'}*/
    ]
    var showVlas={
        西北 : [cockpitData.cockpit010,cockpitData.cockpit042] ,
        华北 : [cockpitData.cockpit011,cockpitData.cockpit043] ,
        东北 : [cockpitData.cockpit012,cockpitData.cockpit044] ,
        华南 : [cockpitData.cockpit014,cockpitData.cockpit046] ,
        西南 : [cockpitData.cockpit015,cockpitData.cockpit047] ,
        华中 : [cockpitData.cockpit016,cockpitData.cockpit048] ,
        华东 : [cockpitData.cockpit013,cockpitData.cockpit045] ,
    }
    let option = {
        title: {
            text: '',
            left: 'center',
            top: '0%',
            textStyle: {
                color: '#ffffff',
                fontStyle: 'normal',
                fontWeight: 800,
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
                color: ['#FFF', '#210A57', '#210A57', '#330440', '#210A57', '#213E66', '#213E66', '#264240'],
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
                        var val = param.name + `\n` + "T: ";
                        val += showVlas[param.name][1]+'\n' + "S: ";
                        val += showVlas[param.name][0];
                        return val
                    },
                    color: '#FFF',
                    fontSize: nowSize(),
                },
                symbol: 'circle',
                symbolSize: 1,
                data: points1,
                z: 4
            },
        ]
    };
    myChart.setOption(option,true);
    window.addEventListener('resize', function() {
        myChart.setOption(option, true);
    });
    function nowSize(){
        let nowClientWidth = 12*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}