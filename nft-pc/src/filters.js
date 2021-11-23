import store from '@/store'

const isAbsoluteURL = str => /^[a-z][a-z0-9+.-]*:/.test(str);

export function fullImageUrl(url){
  // not exist url
  if(!url) return '';
  // ipfs url
  if(url.toLowerCase().startsWith("ipfs:/")) {
    let urlArr = url.split("/");
    if(url.indexOf("image") > -1 || url.indexOf("animation") > -1) {
      url = "ipfs/" + urlArr[urlArr.length -2] + "/" + urlArr[urlArr.length - 1];
    } else {
      url = "ipfs/" + urlArr[urlArr.length - 1];
    }
    return store.state.config.ipfsUrl+'/'+url;
  }
  // not ipfs url
  if(isAbsoluteURL(url)){
    return url;
  }
  return store.state.config.StaticPath + url
}

export function ellipsisAddress(address){
  return address.slice(0, 11) + "..." + address.slice(-4)
}

export function decimal(num,v) {
  var vv = Math.pow(10,v);
  return Math.round(num*vv)/vv;
}
 

export function timeFormat(time) {
  var previous = new Date(time * 1000);
  var current = new Date();
  var msPerMinute = 60 * 1000;
  var msPerHour = msPerMinute * 60;
  var msPerDay = msPerHour * 24;
  var msPerMonth = msPerDay * 30;
  var msPerYear = msPerDay * 365;

  var elapsed = current - previous;
  if (elapsed < msPerMinute) {
    return Math.round(elapsed/1000) + ' seconds ago';
  }else if (elapsed < msPerHour) {
    return Math.round(elapsed/msPerMinute) + ' minutes ago';
  }else if (elapsed < msPerDay ) {
    return Math.round(elapsed/msPerHour ) + ' hours ago';
  }else if (elapsed < msPerMonth) {
    return Math.round(elapsed/msPerDay) + ' days ago';
  }else if (elapsed < msPerYear) {
    return Math.round(elapsed/msPerMonth) + ' months ago';
  }
  else {
    return Math.round(elapsed/msPerYear ) + ' years ago';
  }
}
