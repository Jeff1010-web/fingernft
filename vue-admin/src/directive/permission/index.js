import permission from './permission'

export default {
  install(Vue, options) {
    Vue.directive('permission', permission)
  }
}

/* const install = function(Vue) {
  Vue.directive('permission', permission)
}

if (window.Vue) {
  window['permission'] = permission
  Vue.use(install); // eslint-disable-line
}

permission.install = install
export default permission*/
