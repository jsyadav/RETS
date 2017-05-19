Ext.setup({
    icon: 'icon.png',
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    glossOnIcon: false,
    onReady: function() {

        var form;

        var formBase = {
            scroll: 'vertical',
            url   : mtgr.loginURL,
            standardSubmit : false,
            items:[
            {
                    xtype: 'fieldset',
                    title: 'Login',
                    instructions: 'Please enter the username/password above.',
                    defaults: {
                        required: true,
                        labelAlign: 'left',
                        labelWidth: '40%'
                    },
                    items: [
                    {
                        xtype: "textfield",
                        label: "Username",
                        name: "j_username",
                        allowBlank: false,
                        vtype: "email",

                        ref: "usernameTextbox"
                    },
                    {
                        xtype: "textfield",
                        label: "Password",
                        name: "j_password",
                        inputType: "password",
                        allowBlank: false,

                        ref: "passwordTextbox"
                    }]
            }
		],
            listeners : {
                submit : function(form, result){
                    console.log('success', Ext.toArray(arguments));
                },
                exception : function(form, result){
                    console.log('failure', Ext.toArray(arguments));
                }
            },

            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items: [
                        {xtype: 'spacer'},
                        {
                            text: 'Reset',
                            handler: function() {
                                form.reset();
                            }
                        },
                        {
                            text: 'Login',
                            ui: 'confirm',
                            handler: function() {
                                form.submit({
                                    method: 'POST',
                                    scope: this,

                                    success:function(form, action){
                                        //var url = this.redirectUrl;

                                        window.location = "./DataFetcher.jsp";

                                    },

                                    failure:function(form, action){

                                    }
                                });
                            }
                        }
                    ]
                }
            ]
        };

        if (Ext.is.Phone) {
            formBase.fullscreen = true;
        } else {
            Ext.apply(formBase, {
                autoRender: true,
                floating: true,
                modal: true,
                centered: true,
                hideOnMaskTap: false,
                height: 385,
                width: 480
            });
        }

        form = new Ext.form.FormPanel(formBase);
        form.show();
    }
});