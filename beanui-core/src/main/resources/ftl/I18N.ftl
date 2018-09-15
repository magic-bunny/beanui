<#macro createI18N element, attr>
<#if attr!=''>
<#if element.i18n??>:${attr}="${r'$'}t('${element.i18n}')"<#else>${attr}="${element.content.label}"</#if>
<#else>
${r'{{'}<#if element.i18n??>${r'$'}t('${element.i18n}')<#else>${element.content.label}</#if>${r'}}'}
</#if>
</#macro>