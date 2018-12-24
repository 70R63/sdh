/*!
  * $script.js JS loader & dependency manager
  * https://github.com/ded/script.js
  * (c) Dustin Diaz 2014 | License MIT
  */
!function(e,t){"undefined"!=typeof module&&module.exports?module.exports=t():"function"==typeof define&&define.amd?define(t):this.$script=t()}(0,function(){function d(e,t){for(var n=0,r=e.length;n<r;++n)if(!t(e[n]))return s;return 1}function u(e,t){d(e,function(e){return!t(e)})}function l(e,t,n){function r(e){return e.call?e():g[e]}function o(){if(!--c)for(var e in g[s]=1,i&&i(),w)d(e.split("|"),r)&&!u(w[e],r)&&(w[e]=[])}e=e[p]?e:[e];var a=t&&t.call,i=a?t:n,s=a?e.join(""):t,c=e.length;return setTimeout(function(){u(e,function e(t,n){return null===t?o():(!n&&!/^https?:\/\//.test(t)&&m&&(t=-1===t.indexOf(".js")?m+t+".js":m+t),y[t]?(s&&(v[s]=1),2==y[t]?o():setTimeout(function(){e(t,!0)},0)):(y[t]=1,s&&(v[s]=1),void f(t,o)))})},0),l}function f(e,t){var n,r=a.createElement("script");r.onload=r.onerror=r[h]=function(){r[c]&&!/^c|loade/.test(r[c])||n||(r.onload=r[h]=null,n=1,y[e]=2,t())},r.async=1,r.src=o?e+(-1===e.indexOf("?")?"?":"&")+o:e,i.insertBefore(r,i.lastChild)}var m,o,a=document,i=a.getElementsByTagName("head")[0],s=!1,p="push",c="readyState",h="onreadystatechange",g={},v={},w={},y={};return l.get=f,l.order=function(n,r,o){!function e(t){t=n.shift(),n.length?l(t,e):l(t,r,o)}()},l.path=function(e){m=e},l.urlArgs=function(e){o=e},l.ready=function(e,t,n){e=e[p]?e:[e];var r,o=[];return!u(e,function(e){g[e]||o[p](e)})&&d(e,function(e){return g[e]})?t():(r=e.join("|"),w[r]=w[r]||[],w[r][p](t),n&&n(o)),l},l.done=function(e){l([null],e)},l
/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */}),// jshint ignore:line
function(a){
/*
	 * Only allow wildcard 2 levels deep.
	 * See webApplicationInjectorTest.js for more details
	 */
var r=function(){
// to not expose validAllowOriginPattern
return new RegExp(/^(([-*a-zA-Z0-9]+[.])*([-a-zA-Z0-9]+[.]))?[-a-zA-Z0-9]+(:[0-9]{1,5})?$/)},e=[a.location.host],t=document.currentScript||document.querySelector("script#smartedit-injector");
/*
     * START of Whitelisting: expected CSV of ant-like wildcards with "*"
     * to be found in either data-smartedit-allow-origin attribute or allow-origin query parameter (for smarteditaddon support)
     */if(t){var o=t.getAttribute("data-smartedit-allow-origin");if(!o){var n=a.document.createElement("a");n.href=t.src,n.search.replace(/([?&])([^&=]+)=([^&]*)?/g,function(e,t,n,r){"allow-origin"===n&&(o=decodeURI(r))})}o&&(e=e.concat(o.split(",")))}var i=e.map(function(e){var t=e.trim();if(r().test(t)){var n=["^","$"].join(t.replace(/\./g,"\\.").replace(/\*/g,"[-a-zA-Z0-9]*"));return new RegExp(n)}throw new Error("Allowed whitelist characters are a-Z, A-Z, 0-9, - or period. A wildcard * can be used to represent a prefixed domain. E.g.: *.domain.com can be used for subdomain.domain.com.")});function s(e,t){if(!/^(https?:)\/\/([-.a-zA-Z0-9]+(:[0-9]{1,5})?)$/.test(e))return!1;var n=a.document.createElement("a");return n.href=e,("https:"!==t.protocol||"https:"===n.protocol)&&i.some(function(e){return e.lastIndex=0,e.test(n.host)})}
// END of Whitelisting
var c="smartEditBootstrap";parent.postMessage({pk:Math.random(),gatewayId:c,eventId:"loading",data:{location:document.location.href}},"*"),a.onbeforeunload=function(){parent.postMessage({pk:Math.random(),gatewayId:c,eventId:"unloading",data:{location:document.location.href}},"*")},function e(){parent.postMessage({pk:Math.random(),gatewayId:"heartBeatGateway",eventId:"heartBeat",data:{location:document.location.href}},"*"),setTimeout(e,500)}(),a.addEventListener("load",function(){parent.postMessage({pk:Math.random(),gatewayId:c,eventId:"bootstrapSmartEdit",data:{location:document.location.href}},"*")});var d=function(e,t,n){n<t.length&&$script(t[n],function(){d(e,t,n+1)})},u=function(e,t,n){var r=document.createElement("link");r.rel="stylesheet",r.href=t[n],e.appendChild(r),n+1<t.length&&u(e,t,n+1)};
// Listen to message from child window
a.addEventListener("message",function(e){
// Do not remove the line below as it will expose XSS vulnerabilities.
if(!s(e.origin,a.location))throw new Error(e.origin+" is not allowed to override this storefront.");var t=e.data;if(t.gatewayId===c&&"bundle"===t.eventId){var n=t.data;if(a.smartedit=a.smartedit||{},n.resources&&n.resources.properties)for(var r in n.resources.properties)// jshint ignore:line
a.smartedit[r]=n.resources.properties[r];var o=document.getElementsByTagName("head")[0];
//JS Files
n.resources&&n.resources.js&&0<n.resources.js.length&&d(o,n.resources.js,0),
//CSS Files
n.resources&&n.resources.css&&0<n.resources.css.length&&u(o,n.resources.css,0)}},!1),a.SmarteditWAI={},a.SmarteditWAI.isAllowed=s,a.SmarteditWAI.createAllowOriginRegex=r,Object.freeze(a.SmarteditWAI)}(window);