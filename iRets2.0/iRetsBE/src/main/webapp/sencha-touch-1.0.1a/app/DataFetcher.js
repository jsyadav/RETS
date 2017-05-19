Ext.setup({
    icon: 'icon.png',
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    glossOnIcon: false,
    onReady: function() {
        var panel;

        var cfg = {
            layout: {
                type: 'vbox',
                pack: 'center'
            },
            defaults: {
                xtype: 'button',
                width  : 180,
                cls: 'demobtn',
                ui : 'confirm-small'
            },
            items: [{
                text: 'Fetch All Property Data',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL +'/DataFetcher',
                        params: {
                            fetchFullData: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'fetchFullData call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Fetch Open Houses',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                        	fetchOpenHouseData: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'fetch open house call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Run Data Updater',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                        	runDataUpdater: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'data updater call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Fetch Missing Photos',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            fetchAllPhoto: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'fetchAllPhoto call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Fetch Non Equal Count Photos',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            getAllNonEqualCountPhotos: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'non equal photo call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                xtype:  "spacer",
                height: 10
            },
            {
                text: 'Start prop-data cron',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            scheduleDataUpdater: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'scheduleDataUpdater call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Stop prop-data cron',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            stopDataUpdater: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'stopDataUpdater call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                xtype:  "spacer",
                height: 10
            },
//            {
//                text: 'Start photo cron',
//                handler: function() {
//                    panel.setLoading(true,true);
//                    Ext.Ajax.request({
//                        url: '/DataFetcher',
//                        params: {
//                            schedulePhotoUpdater: "true"
//                        },
//                        success: function(response, opts) {
//                            panel.setLoading(false);
//                            Ext.Msg.alert('Success', 'schedulePhotoUpdater call success', Ext.emptyFn);
//                        }
//                    });
//                }
//            },
//            {
//                text: 'Stop photo cron',
//                handler: function() {
//                    panel.setLoading(true,true);
//                    Ext.Ajax.request({
//                        url: '/DataFetcher',
//                        params: {
//                            stopPhotoUpdater: "true"
//                        },
//                        success: function(response, opts) {
//                            panel.setLoading(false);
//                            Ext.Msg.alert('Success', 'stopPhotoUpdater call success', Ext.emptyFn);
//                        }
//                    });
//                }
//            },
//            {
//                xtype:  "spacer",
//                height: 10
//            },
            {
                text: 'Make Photoes Live...',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            updateActualPhotoCount: "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'All photos are live ', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                text: 'Make Geos Live...',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            updateLatLong : "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'updateLatLong call success', Ext.emptyFn);
                        }
                    });
                }
            },
            {
                xtype:  "spacer",
                height: 10
            },
            {
                text: 'Force Get Lat/long...',
                handler: function() {
                    panel.setLoading(true,true);
                    Ext.Ajax.request({
                        url: mtgr.baseURL+'/DataFetcher',
                        params: {
                            populateLatLong : "true"
                        },
                        success: function(response, opts) {
                            panel.setLoading(false);
                            Ext.Msg.alert('Success', 'Got lat/long for all props. ', Ext.emptyFn);
                        }
                    });
                }
            }]
        };

        if (Ext.is.Phone) {
            cfg.fullscreen = true;
        } else {
            Ext.apply(cfg, {
                autoRender: true,
                floating: true,
                modal: true,
                centered: true,
                hideOnMaskTap: false,
                height: 385,
                width: 480
            });
        }

        panel = new Ext.Panel(cfg);

        panel.show();
    }
});
