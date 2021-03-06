var portalLayout;
var portal;
$(function() {

	portalLayout = $('#portalLayout').layout({
		fit : true
	});
	$(window).resize(function() {
		portalLayout.layout('panel', 'center').panel('resize', {
			width : 1,
			height : 1
		});
	});

	panels = [ {
		id : 'p1',
		title : '上月同比情况',
		height : 200,
		collapsible : true,
		href : ctx + "/tour/noReported!lastMonthSameCompareList.action",
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p1").panel('expand').panel('refresh');
			}
		} ]
	}, {
		id : 'p2',
		title : '最新上报数据',
		height : 200,
		collapsible : true,
		href : ctx + "/tour/noReported!last5ReportedList.action",
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p2").panel('expand').panel('refresh');
			}
		} ]
	}, {
		id : 'p3',
		title : '资源下载',
		height : 200,
		collapsible : true,
		content : '<br>本系统建议使用谷歌浏览器，<a href="'+ctx+'/tools/chrome.exe">下载谷歌浏览器</a><br><br>'
			+ '手机客户端下载，<a href="'+ctx+'/tools/tour-android.apk">下载手机客户端</a>',
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p3").panel('expand').panel('refresh');
			}
		} ]
	}, {
		id : 'p4',
		title : '上季度同比情况',
		height : 200,
		collapsible : true,
		href : ctx + "/tour/noReported!lastQuarterSameCompareList.action",
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p4").panel('expand').panel('refresh');
			}
		} ]
	}, {
		id : 'p5',
		title : '上月统计',
		height : 200,
		collapsible : true,
		href : ctx + '/tour/noReported!lastMonthStatisticList.action',
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p5").panel('expand').panel('refresh');
			}
		} ]
	}, {
		id : 'p6',
		title : '工作计划',
		height : 200,
		collapsible : true,
		content : '这是工作计划',
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				$("#p6").panel('expand').panel('refresh');
			}
		} ]
	} ];

	portal = $('#portal').portal({
		border : false,
		fit : true,
		onStateChange : function() {
			$.cookie('portal-state', getPortalState(), {
				expires : 7
			});
		}
	});
	var state = $.cookie('portal-state');
	if (!state) {
		state = 'p1,p2,p3:p4,p5,p6';/* 冒号代表列，逗号代表行 */
	}
	addPortalPanels(state);
	portal.portal('resize');

});

function getPanelOptions(id) {
	for (var i = 0; i < panels.length; i++) {
		if (panels[i].id == id) {
			return panels[i];
		}
	}
	return undefined;
}
function getPortalState() {
	var aa = [];
	for (var columnIndex = 0; columnIndex < 2; columnIndex++) {
		var cc = [];
		var panels = portal.portal('getPanels', columnIndex);
		for (var i = 0; i < panels.length; i++) {
			cc.push(panels[i].attr('id'));
		}
		aa.push(cc.join(','));
	}
	return aa.join(':');
}
function addPortalPanels(portalState) {
	var columns = portalState.split(':');
	for (var columnIndex = 0; columnIndex < columns.length; columnIndex++) {
		var cc = columns[columnIndex].split(',');
		for (var j = 0; j < cc.length; j++) {
			var options = getPanelOptions(cc[j]);
			if (options) {
				var p = $('<div/>').attr('id', options.id).appendTo('body');
				p.panel(options);
				portal.portal('add', {
					panel : p,
					columnIndex : columnIndex
				});
			}
		}
	}
}
function messageClick(event) {
	event.preventDefault()
	var url = event.target.href;
	parent.$.modalDialog({
		title : "阅读短消息",
		width : 400,
		height : 450,
		href : url,
		buttons : [
				{
					text : '快速回复',
					iconCls : 'icon-add',
					handler : function() {
						var f = parent.$.modalDialog.handler
								.find('#deskToMessageForm');
						f.submit();
					}
				}, {
					text : '确定',
					iconCls : 'icon-cancel',
					handler : function() {
						parent.$.modalDialog.handler.dialog('close');
					}
				} ]
	});
}
function scheduleClick(event) {
	event.preventDefault()
	var url = event.target.href;
	parent.$.modalDialog({
		title : "查看日程",
		width : 400,
		height : 350,
		href : url,
		buttons : [ {
			text : '确定',
			iconCls : 'icon-cancel',
			handler : function() {
				parent.$.modalDialog.handler.dialog('close');
			}
		} ]
	});
}
