var app = angular.module('certificates', []);

app.controller("TabController", function(){
    this.tab = 1;

    this.isSet = function(checkTab) {
      return this.tab === checkTab;
    };

    this.setTab = function(setTab) {
      this.tab = setTab;
    };
});

app.controller("CertificateController", function($http){
	var control = this;
	control.certificate = {};
	control.certificate.validFrom = new Date();
	control.result = "";
	
	this.generate = function(){
		if(control.certificate.validFrom < control.certificate.validTo){
			$http.post('/certificates/genCertificate', control.certificate).then(function success(response) {
				if(response.data === 'ok'){
					toastr.success('Certificate successfully generated!');
				}else{
					toastr.error(response.data);
				}
			}, function error(response) {
				control.result = "Unknown error ocurred."
			});
		}else{
			toastr.error('Invalid date entries!');
		}
	};
	
	this.resetIssuer = function(){
		if(control.certificate.selfSigned){
			control.certificate.issuerAlias = "";
		}
	}
});



