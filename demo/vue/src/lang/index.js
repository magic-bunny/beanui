import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Cookies from 'js-cookie'
import enElementLocale from 'element-ui/lib/locale/lang/en'
import enLocale from './en'
import zh_CNElementLocale from 'element-ui/lib/locale/lang/zh-CN'
import zh_CNLocale from './zh-CN'

Vue.use(VueI18n)

const messages = {
  'en': {
    ...enLocale,
    ...enElementLocale
  },
  'zh-CN': {
    ...zh_CNLocale,
    ...zh_CNElementLocale
  }
}



const i18n = new VueI18n({
  locale: Cookies.get('language') || 'en',
  messages
})

export default i18n
