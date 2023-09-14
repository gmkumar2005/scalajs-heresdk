/** @type {import('tailwindcss').Config} */
export default {
    content: [
        "./index.html",
        "./src/**/*.scala",
    ],
    theme: {
        colors:{
            gray: {
                '50': '#f5f7fa',
                '100': '#ebeef3',
                '200': '#d2dae5',
                '300': '#aab9cf',
                '400': '#7c94b4',
                '500': '#5c779b',
                '600': '#485e81',
                '700': '#3b4c69',
                '800': '#344259',
                '900': '#2f394b',
                '950': '#1f2532',
            },
            'pickled-bluewood': {
                '50': '#f5f7fa',
                '100': '#ebeef3',
                '200': '#d2dae5',
                '300': '#aab9cf',
                '400': '#7c94b4',
                '500': '#5c779b',
                '600': '#485e81',
                '700': '#3b4c69',
                '800': '#344259',
                '900': '#2f394b',
                '950': '#1f2532',
            },

        },
        extend: {
            fontFamily: {
                'sans': ['Lato', 'sans-serif'], // This will set Roboto as the default sans font
            },
            fontWeight: {
                'thin': 100,
                'normal': 400,
                'semibold': 600,
                'bold': 700,
                'extrabold': 900,
            },
            boxShadow: {
                'custom': '0 25px 60px 2px rgba(69, 130, 255, 0.2)',
            },
        }
    },
    plugins: [],
}
