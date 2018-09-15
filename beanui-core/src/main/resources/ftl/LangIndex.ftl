import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Cookies from 'js-cookie'
<#if langs?size=0>
import enElementLocale from 'element-ui/lib/locale/lang/en'
<#else>
<#list langs as lang>
import ${lang?replace('-', '_')}ElementLocale from 'element-ui/lib/locale/lang/${lang}'
import ${lang?replace('-', '_')}Locale from './${lang}'
</#list>
</#if>

Vue.use(VueI18n)

const messages = {
<#if langs?size=0>
    en: {
        ...enElementLocale
    }
<#else>
<#list langs as lang>
  '${lang}': {
    ...${lang?replace('-', '_')}Locale,
    ...${lang?replace('-', '_')}ElementLocale
  }<#if lang_has_next>,</#if>
</#list>
</#if>
}



const i18n = new VueI18n({
  locale: Cookies.get('language') || 'en',
  messages
})

export default i18n
