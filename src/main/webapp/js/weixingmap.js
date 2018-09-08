//初始化地图对象，加载地图
var map = new AMap.Map("container",
    {
        resizeEnable: true,
        layers: [
            new AMap.TileLayer.Satellite(),
            new AMap.TileLayer.RoadNet()
        ]
    });


var lnglats = [
    [116.449263, 39.902484],
    [117.152388, 39.088625],
    [112.604049, 37.923743],
    [117.020553, 36.841291],
    [113.504928, 34.738357],
    [108.802779, 34.485183],
    [118.73442, 32.116446],
    [123.395369, 41.681236],
    [121.415084, 31.120106],
    [120.360396, 36.07698]
];
var infoWindow = new AMap.InfoWindow({
    offset: new AMap.Pixel(0, -30)
});
for (var i = 0, marker; i < lnglats.length; i++) {
    var marker = new AMap.Marker({
        position: lnglats[i],
        map: map
    });
    if(i==0){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=8" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>北京 一环</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=10">七日六夜狂欢游</a></h5><span>帝都/二锅头/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==1){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=16" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>天津 和平区</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=11">五日四晚游</a></h5><span>湖边/美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==2){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=12" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>太原 晋阳湖</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=12">五日四夜游</a></h5><span></span>美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==3){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=14" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>济南 大明湖</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=13">四日三夜游</a></h5><span>温泉/美女/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==4){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=19" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>郑州 龙湖</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=15">三日两晚游</a></h5><span>沙滩/美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==5){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=22" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>西安 秦墓</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=16">五日四夜自驾游</a></h5><span>沙滩/美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==6){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=23" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>南京 玄武湖</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=17">五日四晚毕业游</a></h5><span>美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==7){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=26" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>沈阳 东陵</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=18">沈阳休闲游</a></h5><span>美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==8){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=27" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>上海 外滩</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=19">五日四晚狂欢游</a></h5><span>沙滩/夜市/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    if(i==9){
        marker.content ='<div style="height: 100px; width: 210px"><div><img style="width: 100px; height: 100px; float: left" src="https://cdn-photos.zanadu.cn/resources/zanadu/bundle/292/key3_2921_bundle.jpg!320x240?v=1522640908"></div>'+
            '<a href="show.html?strategy_id=28" style="line-height: 40px; padding: 10px;font-size: 14px;" class="view-hotel-link" target="_blank">'
            + '<strong>山东 青岛</strong>' + '</a><h5 align="center"><a href="show.html?strategy_id=20">青岛短途游</a></h5><span>沙滩/美女/啤酒/美食</span></div>' ;
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }

}
function markerClick(e) {
    infoWindow.setContent(e.target.content);
    infoWindow.open(map, e.target.getPosition());
}
map.setFitView();