//饼图
function createQuestionCloseLoop(bar,project) {
    option = {
        tooltip: {
            trigger: "axis",
            axisPointer: {
                // 坐标轴指示器，坐标轴触发有效
                type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            right: "4%",
            top: "15%",
            bottom: '2%',
            containLabel: true
        },
        legend: {
            right: '1%',
            data: [
                { name: "测试问题", icon: "circle" },
                { name: "试制问题", icon: "circle" },
                { name: "自测问题", icon: "circle" }
            ],
            // 大小 和位置 文字样式
            itemGap: nowSize(6),
            textStyle: {
                fontSize: nowSize(10),
                color: "#000",
                fontFamily: "SourceHanSansCN-Regular"
            }
        },
        xAxis: [
            {
                type: "value",
                axisPointer: {
                    type: "shadow"
                },
                // 横坐标 分割线等取消显示
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                },
                splitLine: {
                    show: false
                },
                axisLabel: {
                    show: false
                }
            }
        ],
        yAxis: [
            {
                type: "category",
                // 纵坐标数据
                data: [
                    "已解决",
                    "遗留跟踪",
                    "遗留不跟踪"
                ],
                yAxisIndex: 0,
                // 横坐标 分割线等取消显示
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                }
            }
        ],
        series: [
            {
                name: "测试问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(12),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 1111, 6],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12)
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#FFF0A0"
                                },
                                {
                                    offset: 1,
                                    color: "#ffdb5c"
                                }
                            ],
                            false
                        )
                    }
                }
            },
            {
                name: "试制问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(12),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 11, 6],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12),
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#FFABAC"
                                },
                                {
                                    offset: 1,
                                    color: "#ff9f7f"
                                }
                            ],
                            false
                        )
                    }
                }
            },
            {
                name: "自测问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(12),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 11, 6],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12)
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#90BEFF"
                                },
                                {
                                    offset: 1,
                                    color: "#37a2da"
                                }
                            ],
                            false
                        )
                    }
                }
            }
        ]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}